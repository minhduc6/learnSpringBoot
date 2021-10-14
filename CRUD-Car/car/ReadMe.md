Bước 1 : Tạo Project với cấu trúc như sau :



Bước 2 : Tạo File json để lấy dữ liệu đọc File :



Bước 3 : Tạo class Car.java trong model:



Bước 4 : Tạo Repository để đọc file add vào cars và xử lý logic như getAll(), thêm ,sửa ,xóa theo ID , tìm kiếm theo keyword , hay sort theo price hay name :




Bước 5 Tạo CarController và tiêm CarRepository lên để gọi các hàm logic lên xử lý



Bước 6 : Sử dụng các method HTTP POST,GET để xử lý từng nghiệp vụ xong trả về html:



Bước 7 :  Tạo trang home.html trả về danh sách các car :




Bước 8 : Tạo Car-form.html để thêm và sửa car


Bước 9 : Để search 1 car theo keyword em sử dụng @RequestParam để lấy keyword truyền xuông sever và rồi xử lý :

xử lý HTML : 


xử lý dưới sever :


Bước 10 :Để sắp xêp car thì em cũng sử dụng @RequestParam để lấy sắp xếp theo cái gì nếu sapxep = 1 thì sắp theo price , sapxep = 2 thì sắp theo name model

xử lý html :


xử lý dưới sever :





Kết Quả :

Lấy danh sách Car :


Thêm Car :


Sửa Car :


Xóa Car có id 5 :


Tìm Kiếm theo keyword  = me:



Sắp xếp theo price :


Sắp xếp theo name Model :










