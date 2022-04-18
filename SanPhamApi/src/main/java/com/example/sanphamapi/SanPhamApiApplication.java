package com.example.sanphamapi;

import com.example.sanphamapi.model.SanPham;
import com.example.sanphamapi.repository.SanPhamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SanPhamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanPhamApiApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(SanPhamRepository sanPhamRepositoryRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                SanPham sp1 = new SanPham(1,"Ịphone 13","Good",800,1000,2);
                SanPham sp2  = new SanPham(2,"Iphone 13 Pro","Good",1000,1200,800);
                SanPham sp3  = new SanPham(3,"Ịphone 24 Pro Max","good",1300,1500,0);
                sanPhamRepositoryRepository.save(sp1);
                sanPhamRepositoryRepository.save(sp2);
                sanPhamRepositoryRepository.save(sp3);
            }
        };
    }

}
