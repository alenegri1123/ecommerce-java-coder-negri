package com.commerce.negri.services;

import com.commerce.negri.entities.Cart;
import com.commerce.negri.entities.Client;
import com.commerce.negri.entities.Invoice;
import com.commerce.negri.repositories.CartsRepository;
import com.commerce.negri.repositories.ClientsRepository;
import com.commerce.negri.repositories.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoicesService {

    @Autowired
    private InvoicesRepository invoiceRepository;

    @Autowired
    private ClientsRepository clientRepository;

    @Autowired
    private CartsRepository cartRepository;

    public Invoice generateInvoice(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            List<Cart> carts = cartRepository.findByClientIdAndDelivered(clientId, false);
            if (carts.isEmpty()) {
                throw new RuntimeException("Not found products on cart");
            } else {
                Client foundClient = client.get();
                Invoice invoice = new Invoice();
                invoice.setClient(foundClient);
                invoice.setCreated_at(new Date());
                double total = 0.0;
                for (Cart cart : carts) {
                    total += cart.getAmount() * cart.getPrice();
                    cart.setDelivered(true);
                }
                invoice.setTotal(total);
                return invoiceRepository.save(invoice);
            }
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public Invoice getInvoicesByClientId(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            List<Invoice> invoices = client.get().getInvoices();
            if (invoices.isEmpty()) {
                throw new RuntimeException("No invoices found for the client");
            }
            Invoice lastInvoice = invoices.get(invoices.size() - 1);
            return lastInvoice;
        } else {
            throw new RuntimeException("Client not found");
        }
    }
}
