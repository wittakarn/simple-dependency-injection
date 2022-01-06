package com.thaisoftplus.simple.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.thaisoftplus.simple.mapper.PathMapper;
import com.thaisoftplus.simple.repository.DirectoryRepository;

public class DirectoryRepositoryTest {
    @Test
    public void shouldThrowExceptionWhenDirectoryNotExist() {
        PathMapper mockPathMapper = Mockito.mock(PathMapper.class);

        DirectoryRepository repository = new DirectoryRepository(mockPathMapper);

        assertThrows(IOException.class, () -> repository.listFilesUsingFileWalk("D:\\", 1), "No exception throws");
    }

    @Test
    public void shouldCallPathMapperProperly() throws IOException {
        PathMapper mockPathMapper = Mockito.mock(PathMapper.class);

        DirectoryRepository repository = new DirectoryRepository(mockPathMapper);
        repository.listFilesUsingFileWalk("E:\\workspaces\\other\\simple-dependency-injection\\src\\main\\java\\com\\thaisoftplus\\simple\\repository", 1);
        ArgumentCaptor<Path> pathCaptor = ArgumentCaptor.forClass(Path.class);

        Mockito.verify(mockPathMapper, Mockito.times(2)).mapFileName(pathCaptor.capture());

        List<Path> paths = pathCaptor.getAllValues();
        assertEquals("DirectoryRepository.java", paths.get(0).getFileName().toString());
        assertEquals("IDirectoryRepository.java", paths.get(1).getFileName().toString());
    }
}
