package com.example.catalogservice.service;

import com.example.catalogservice.repository.CatalogRepository;
import com.example.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;


    public List<ResponseCatalog> getAllCatalog() {
        return catalogRepository.findAll().stream().map(ResponseCatalog::new).collect(Collectors.toList());
    }
}
