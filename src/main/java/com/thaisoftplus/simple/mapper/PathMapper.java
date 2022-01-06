package com.thaisoftplus.simple.mapper;

import java.nio.file.Path;

public class PathMapper implements IPathMapper {
    @Override
    public String mapFileName(Path path) {
        return path.getFileName().toString();
    }
}
