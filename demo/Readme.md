Bước 1 : Tạo CSV 


<img width="449" alt="csv" src="https://user-images.githubusercontent.com/72613060/137345588-5ac5856d-d96b-4717-a223-4a56cb5e7fd8.png">

Bước 2 : Đọc CSV



<img width="544" alt="readFile" src="https://user-images.githubusercontent.com/72613060/137345636-6f5ff648-fada-4fdd-bdbe-e951bcccd0ea.png">
Bước 3 Tạo Entity Employee :
<img width="328" alt="model" src="https://user-images.githubusercontent.com/72613060/137345776-06edc7bb-8a30-4aa2-930b-5de71db02eb3.png">

Tầng Repo :

<img width="395" alt="Tang Repo" src="https://user-images.githubusercontent.com/72613060/137345797-5b771a2c-f683-4fe8-a1a6-ce5c84a6aba0.png">
<img width="368" alt="updateLast" src="https://user-images.githubusercontent.com/72613060/137595154-d0d53868-4628-4802-b235-88487ef65c30.png">
<img width="403" alt="add" src="https://user-images.githubusercontent.com/72613060/137345849-1afd1648-66f4-4c01-a259-8cd10fbfc32d.png">
<img width="371" alt="get" src="https://user-images.githubusercontent.com/72613060/137345870-56cc7ec8-03d4-4b9e-bc05-161fcd65f5ae.png">
<img width="454" alt="update" src="https://user-images.githubusercontent.com/72613060/137345885-76864f7a-fb9f-471a-ab54-984f1b04fcb4.png">
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





Ở Đây e có làm theo 2 cách :
Cách 1 : em sủ dụng RequestParam ở trang home :

<img width="627" alt="timkiem" src="https://user-images.githubusercontent.com/72613060/137346728-b2df07d5-4042-4342-aa57-f679c570ae01.png">

<img width="526" alt="searchParam" src="https://user-images.githubusercontent.com/72613060/137347284-5f08a523-df18-48f2-bd1d-219eec4ada1a.png">

Cách 2 : em sử dụng HTTP POST view trả 1 searchRequest trong modalAttr xong lấy searchRequest làm key gọi hàm ở tầng dưới lên xử lý ở href : /search :


<img width="330" alt="searchRequest" src="https://user-images.githubusercontent.com/72613060/137348214-67bab7e2-10bd-457e-bc77-f56b4a38be67.png">





Buổi 2 : 

Em sử dụng thymeleaf layout dialect base-layout gồm navbar,content ,optional,footer như hướng dẫn trên lớp
ở đây em có sử dụng bootstrap

Trang Home:

<img width="958" alt="pageHome" src="https://user-images.githubusercontent.com/72613060/137595283-196e1b4b-144b-4caf-b2a6-32bdf593ba46.png">

Trang Form add :

<img width="920" alt="formAdd" src="https://user-images.githubusercontent.com/72613060/137595295-03c39072-ef8b-427c-9d42-a1bf1d2e0c68.png">

Trang Form edit :

<img width="941" alt="formEdit" src="https://user-images.githubusercontent.com/72613060/137595303-31f14833-2235-433c-8499-646d59942382.png">

Trang View Detail :


<img width="956" alt="viewDetail1" src="https://user-images.githubusercontent.com/72613060/137595317-316bf3af-dde7-4e76-9fe0-ffbc7ebf1f2f.png">

Trang tìm kiếm :

<img width="956" alt="timkiemResult" src="https://user-images.githubusercontent.com/72613060/137595323-0e73fc2e-7699-4a05-9337-67b31e2dd067.png">

Các Chức năng CRUD tìm kiếm vẫn được xử lý như buổi trước ạ


Buổi 3 :
Upload File :

<img width="412" alt="fileup" src="https://user-images.githubusercontent.com/72613060/138644196-03d29f9d-459f-4927-9615-7dd36d15d8b5.png">

config : 

<img width="430" alt="fileconfig" src="https://user-images.githubusercontent.com/72613060/138644224-630510b1-1996-4378-bbf1-dbfe7d61c235.png">

controller :

<img width="677" alt="fileController" src="https://user-images.githubusercontent.com/72613060/138644253-b0ebde38-0d58-4502-87dc-24dce8e43721.png">

Validate :

<img width="313" alt="validation" src="https://user-images.githubusercontent.com/72613060/138644328-4cfffb8a-b84d-4c16-b0cc-d020d7897586.png">


<img width="545" alt="viewValidate" src="https://user-images.githubusercontent.com/72613060/138644336-603d55d3-728d-468e-b53c-8c8242e563f6.png">

Kết Quả

<img width="647" alt="validateResult" src="https://user-images.githubusercontent.com/72613060/138644353-7df68fa9-336c-47bd-80fb-bd84f3af939b.png">

