package com.example.crudapi;

import com.example.crudapi.enitity.KhachHang;
import com.example.crudapi.repository.KhachhangRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(KhachhangRepository khachhangRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                KhachHang khachHang1 = new KhachHang(1,"Dương Minh Đức","Bạch Mai","123");
                KhachHang khachHang2 = new KhachHang(2,"Dương Minh Thảo","Cầu Giấy","456");
                KhachHang khachHang3 = new KhachHang(3,"Dương Minh Trí","Giảng Võ","789");
                khachhangRepository.save(khachHang1);
                khachhangRepository.save(khachHang2);
                khachhangRepository.save(khachHang3);
            }
        };
    }

}
