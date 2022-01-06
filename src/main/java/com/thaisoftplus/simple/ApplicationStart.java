package com.thaisoftplus.simple;

import java.util.List;

import com.thaisoftplus.simple.mapper.PathMapper;
import com.thaisoftplus.simple.repository.DirectoryRepository;
import com.thaisoftplus.simple.service.DirectoryService;

public class ApplicationStart {
    public static void main(String[] args) {
        DirectoryService service = new DirectoryService(new DirectoryRepository(new PathMapper()));

        List<String> files = service.getFiles("E:\\all-config");

        files.forEach(s -> System.out.println(s));
    }
}
