Bước 1 : Viết tạo ra RestController để Restful API
![3](https://user-images.githubusercontent.com/72613060/133664051-5cb092b4-ab7f-4ecf-9caa-4124fad7d7fb.png)


Bước 2 Viết các hàm Imp từ class Dao xử lý logic

![1](https://user-images.githubusercontent.com/72613060/133663914-65bafc2d-5554-4e59-82be-8c41c315b0c3.png)



Bước 3: sử dụng @Authorwired để tiêm class Dao vào Controller
![2](https://user-images.githubusercontent.com/72613060/133664087-3e80de65-67c3-4cc5-a5cd-a6691b42dde3.png)


Bước 4 : gọi các hàm viết ở BookDao ở các HTTP method thực hiện các công việc tìm kiếm id ,thêm , xóa , sửa theo id

![3](https://user-images.githubusercontent.com/72613060/133664051-5cb092b4-ab7f-4ecf-9caa-4124fad7d7fb.png)

Bước 5 : Xử lý Exception nếu như tìm kiếm id không có trong list book ta đưa ra Exception : Not Found Exception

![4](https://user-images.githubusercontent.com/72613060/133664210-5e8b6be3-5227-4c4b-87e0-21b811508ab8.png)

![5](https://user-images.githubusercontent.com/72613060/133664225-4e9cece0-718a-41ba-87ba-a95352081165.png)


Bước 6 : Test Kết quả trên POSTMAN

Lấy ra list book :


![6](https://user-images.githubusercontent.com/72613060/133664268-a3547190-800a-42af-8df2-a653391ef818.png)


Tìm kiếm theo id :


![7](https://user-images.githubusercontent.com/72613060/133664281-01bbcb77-84e9-4be6-b677-4b604be3e2a4.png)


Nếu Không Có đưa ra Exception :

![8](https://user-images.githubusercontent.com/72613060/133664296-7472c61d-998c-4133-bc8f-74e96dae93c9.png)



Thêm sách vào List :


![10](https://user-images.githubusercontent.com/72613060/133664312-ea3e59a7-9df0-49ab-829f-01f8b5b29ef6.png)



Update Theo ID:


![11](https://user-images.githubusercontent.com/72613060/133664341-87518c45-c84f-4cf2-969c-0076b252803a.png)


Delete Theo ID :

![12](https://user-images.githubusercontent.com/72613060/133664375-a971456e-164b-4671-9e6f-42b4be8cc02d.png)
