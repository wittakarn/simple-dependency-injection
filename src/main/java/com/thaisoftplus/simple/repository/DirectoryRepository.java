package com.thaisoftplus.simple.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.thaisoftplus.simple.mapper.IPathMapper;

public class DirectoryRepository implements IDirectoryRepository {
    private IPathMapper pathMapper;

    public DirectoryRepository(IPathMapper pathMapper) {
        this.pathMapper = pathMapper;
    }

    @Override
    public List<String> listFilesUsingFileWalk(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream.filter(file -> !Files.isDirectory(file)).map(file -> this.pathMapper.mapFileName(file)).collect(Collectors.toList());
        }
    }
}
