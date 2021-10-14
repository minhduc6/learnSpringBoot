Bước 1 : Viết BookController để thực hiện method HTTP Get,POST,... và gọi các hàm xử lý logic từ bài trước để xử lý



![1](https://user-images.githubusercontent.com/72613060/133954250-ba3bb57e-f1b3-4d24-8816-59720459bd2c.png)


Bước 2 : Để hiển thị list danh sách các em tạo  file html allbooks ở đây em có sử dụng bootstrap để hiển thị :

sử dụng thymleaf for-each để hiển thị:


![2](https://user-images.githubusercontent.com/72613060/133954258-51cb947b-61e3-4e6e-ad2a-a190a1cf7522.png)



Đât là kết quả : 

![3](https://user-images.githubusercontent.com/72613060/133954264-0e3303b0-aad4-4c92-aa78-9f50eb54c2ff.png)


Bước 3  : Để thêm 1 book mơi em tạo ra file html book_form như trên :

![4](https://user-images.githubusercontent.com/72613060/133954269-d0f8e0e9-7bd4-42d1-ad51-9a4899bdbfd6.png)



Kết Quả :

![10](https://user-images.githubusercontent.com/72613060/133955752-35a0b03d-6f50-4fab-901b-3c81c8421861.png)
![11](https://user-images.githubusercontent.com/72613060/133955761-5f1f9093-995d-42d0-a8ba-8d109b32b5c4.png)


Bước 4 : Update book theo id thì cũng như tạo 1 book mới nhưng khi add id chưa có còn update thì có rồi và tìm kiếm book theo ID  rồi sửa

và đều sử dụng method POST("/book/save") book_form 

![6](https://user-images.githubusercontent.com/72613060/133954288-3b8f7bb3-5bdd-4d26-9c05-4fb562ae7fce.png)



Kết quả :

![7](https://user-images.githubusercontent.com/72613060/133954303-365f9dfb-bbca-4256-a8f1-52167dda817d.png)


Bước 5 : Delete Book thì cũng tương tự tìm kiềm theo id rồi xóa và redirect về allbooks




Bước 6 : Tìm kiếm theo Id :


Em sử dụng request Param nhập ID trong allbook :

![8](https://user-images.githubusercontent.com/72613060/133954350-7df8b22c-99e6-4f3f-ab4d-496879a1d590.png)

KQ:

![9](https://user-images.githubusercontent.com/72613060/133954338-ece921c3-91ed-4627-9745-81fc94c0cc36.png)





























