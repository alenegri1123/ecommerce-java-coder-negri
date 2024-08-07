package com.commerce.negri.repositories;

import com.commerce.negri.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, Long> {
}
