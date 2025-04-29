package com.cboard.marketplace.marketplace_backend.service;


import com.cboard.marketplace.marketplace_backend.dao.ItemDao;
import com.cboard.marketplace.marketplace_backend.dao.TransactionDao;
import com.cboard.marketplace.marketplace_backend.dao.UserArchiveDao;
import com.cboard.marketplace.marketplace_backend.dao.UserDao;
import com.cboard.marketplace.marketplace_backend.model.*;
import com.cboard.marketplace.marketplace_backend.model.DtoMapping.TransactionMapper;
import com.cboard.marketplace.marketplace_backend.model.DtoMapping.UserMapper;
import com.cboard.marketplace.marketplace_common.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService
{
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    UserArchiveDao userArchiveDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    TransactionMapper transactionMapper;



    public ResponseEntity<List<TransactionDto>> getAllTransactions()
    {
        List<Transaction> transactions = transactionDao.findAll();
        List<TransactionDto> dtos = new ArrayList<>();
        try
        {
            for(Transaction transaction : transactions)
                dtos.add(transactionMapper.transactionToDto(transaction));

            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(dtos, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<TransactionDto>> getAllTransactionsByBuyer(int buyerId)
    {
        List<Transaction> transactions = transactionDao.findByBuyer_UserId(buyerId);
        List<TransactionDto> dtos = new ArrayList<>();
        try
        {
            for(Transaction transaction : transactions)
                dtos.add(transactionMapper.transactionToDto(transaction));

            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(dtos, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<TransactionDto>> getAllTransactionsBySeller(int sellerId)
    {
        List<Transaction> transactions = transactionDao.findBySeller_UserId(sellerId);
        List<TransactionDto> dtos = new ArrayList<>();
        try
        {
            for(Transaction transaction : transactions)
                dtos.add(transactionMapper.transactionToDto(transaction));

            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(dtos, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> purchaseItem(int itemId, int buyerId)
    {
        try
        {
            Item item = itemDao.findByItemId(itemId);
            User buyer = userDao.findById(buyerId);

            UserArchive buyerArc = userArchiveDao.findById(buyerId);
            UserArchive sellerArc = userArchiveDao.findById(item.getUser().getUserId());

            Transaction sale = new Transaction();
            sale.setItem(item);
            sale.setBuyer(buyerArc);
            sale.setSeller(sellerArc);
            transactionDao.save(sale);

            item.setUser(buyer);
            item.setAvailable(false);
            itemDao.save(item);

            return new ResponseEntity<>("Sale successful", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Error occurred", HttpStatus.BAD_REQUEST);
        }

    }
}
