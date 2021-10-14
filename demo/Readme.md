Bước 1 : Tạo CSV 


<img width="449" alt="csv" src="https://user-images.githubusercontent.com/72613060/137345588-5ac5856d-d96b-4717-a223-4a56cb5e7fd8.png">

Bước 2 : Đọc CSV



<img width="544" alt="readFile" src="https://user-images.githubusercontent.com/72613060/137345636-6f5ff648-fada-4fdd-bdbe-e951bcccd0ea.png">
Bước 3 Tạo Entity Employee :
<img width="328" alt="model" src="https://user-images.githubusercontent.com/72613060/137345776-06edc7bb-8a30-4aa2-930b-5de71db02eb3.png">

Tầng Repo :

<img width="395" alt="Tang Repo" src="https://user-images.githubusercontent.com/72613060/137345797-5b771a2c-f683-4fe8-a1a6-ce5c84a6aba0.png">

<img width="403" alt="add" src="https://user-images.githubusercontent.com/72613060/137345849-1afd1648-66f4-4c01-a259-8cd10fbfc32d.png">
<img width="371" alt="get" src="https://user-images.githubusercontent.com/72613060/137345870-56cc7ec8-03d4-4b9e-bc05-161fcd65f5ae.png">
<img width="454" alt="update" src="https://user-images.githubusercontent.com/72613060/137345885-76864f7a-fb9f-471a-ab54-984f1b04fcb4.png">
<img width="374" alt="delete" src="https://user-images.githubusercontent.com/72613060/137345914-058c5695-4b53-4f7f-af9a-4eb9cd0ee75f.png">
<img width="389" alt="search" src="https://user-images.githubusercontent.com/72613060/137345975-fd5dfe91-8378-413b-92e1-d23b26b6fd0e.png">

Tầng Controller :


<img width="464" alt="controller1" src="https://user-images.githubusercontent.com/72613060/137346044-8acaa8e6-6037-4ee3-b66f-1285d26fc0c6.png">
<img width="401" alt="controller2" src="https://user-images.githubusercontent.com/72613060/137346054-77766a90-f48c-4457-a036-f7956e5fcc33.png">
<img width="554" alt="controller3" src="https://user-images.githubusercontent.com/72613060/137346065-efcbe1ac-6ce0-4de9-9f06-2d33491ffa70.png">

View :


<img width="619" alt="list" src="https://user-images.githubusercontent.com/72613060/137346235-81cb9687-0f72-4d48-9987-c68e6e46b9c4.png">
<img width="621" alt="viewDetail" src="https://user-images.githubusercontent.com/72613060/137346240-b1e26bbc-821d-44ab-b08c-164479e39cbb.png">
<img width="605" alt="form" src="https://user-images.githubusercontent.com/72613060/137346250-ae43163e-1234-4438-9f47-6475a87c3156.png">

Exception :

<img width="592" alt="ex" src="https://user-images.githubusercontent.com/72613060/137348342-7794892f-cf83-48b6-b8b3-4a22808cff04.png">


Kết quả :

ADD :



<img width="359" alt="addResult" src="https://user-images.githubusercontent.com/72613060/137346319-1979d62d-e130-4191-869e-65afdab7a53c.png">
<img width="261" alt="addResult1" src="https://user-images.githubusercontent.com/72613060/137346341-28b124d4-2d27-4fe3-bc5c-3f0528574044.png">

Update :



<img width="204" alt="updateResult" src="https://user-images.githubusercontent.com/72613060/137346404-6e948ea7-3fee-4765-936a-c7c8fc25f929.png">
<img width="233" alt="updateResult1" src="https://user-images.githubusercontent.com/72613060/137346413-67430067-800c-44d7-9b94-3ed15f9ce291.png">

Delete Xóa id 1 :




<img width="206" alt="deleteResult" src="https://user-images.githubusercontent.com/72613060/137346477-2d34bed1-fd6b-4d77-9a92-d7a813a803ee.png">
<img width="521" alt="deleteResult1" src="https://user-images.githubusercontent.com/72613060/137346525-08438f8d-4a64-4193-bb48-836f9d6dff17.png">

Tìm Kiếm :

Ở Đây e có làm theo 2 cách :
Cách 1 : em sủ dụng RequestParam ở trang home :
<img width="627" alt="timkiem" src="https://user-images.githubusercontent.com/72613060/137346728-b2df07d5-4042-4342-aa57-f679c570ae01.png">
<img width="526" alt="searchParam" src="https://user-images.githubusercontent.com/72613060/137347284-5f08a523-df18-48f2-bd1d-219eec4ada1a.png">

Cách 2 : em sử dụng HTTP POST view trả 1 searchRequest trong modalAttr xong lấy searchRequest làm key gọi hàm ở tầng dưới lên xử lý ở href : /search :


<img width="330" alt="searchRequest" src="https://user-images.githubusercontent.com/72613060/137348214-67bab7e2-10bd-457e-bc77-f56b4a38be67.png">


<img width="526" alt="searchParam" src="https://user-images.githubusercontent.com/72613060/137347157-590951a6-060e-4b7c-be5c-46710bb9b150.png">

<img width="223" alt="searchPost" src="https://user-images.githubusercontent.com/72613060/137347303-392ca5b9-b19a-4bb3-ad34-47139243c134.png">

<img width="401" alt="searchPost1" src="https://user-images.githubusercontent.com/72613060/137347317-254ab6f5-a736-46b4-9915-1342ed6c2e78.png">

