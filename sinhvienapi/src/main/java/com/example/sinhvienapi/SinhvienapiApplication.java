package com.example.sinhvienapi;

import com.example.sinhvienapi.entity.SinhVien;
import com.example.sinhvienapi.repository.SinhvienRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SinhvienapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinhvienapiApplication.class, args);
    }

    // Khi chạy chương trình thêm sẵn 3 sinh viên vào cơ sở dữ liệu
    @Bean
    CommandLineRunner initDatabase(SinhvienRepository sinhvienRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                SinhVien sv1 = new SinhVien(1,"Dương Minh Đức",21,"Hà Nội");
                SinhVien sv2 = new SinhVien(2,"Dương Minh Trí",28,"Hồ Chí Minh");
                SinhVien sv3 = new SinhVien(3,"Dương Minh Anh",20,"Nam Định");
                sinhvienRepository.save(sv1);
                sinhvienRepository.save(sv2);
                sinhvienRepository.save(sv3);
            }
        };
    }

}
