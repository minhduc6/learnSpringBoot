// // Thêm công việc
// // Sửa công việc - tiêu đề & trạng thái
// // Xóa công việc
console.log("main.js")
console.log(todos)
// // Lọc công việc theo trạng thái
//
const API_URL = "/api/v1"

let isUpdate = false;
let idUpdate = null;

function getTodosAPI(status) {
    switch (status) {
        case "all": {
            return axios.get(`${API_URL}/todos`)
        }
        case "unactive": {
            return axios.get(`${API_URL}/todos?status=false`)
        }
        case "active": {
            return axios.get(`${API_URL}/todos?status=true`)
        }
        default: {
            return axios.get(`${API_URL}/todos`)
        }
    }
}

async function getTodos(status) {
    try {
        let res = await getTodosAPI(status)
        todos = res.data;

        renderTodos(res.data)
    } catch (error) {
        console.log(error);
    }
}

// Truy cập vào các thành phần
const todoListEl = document.querySelector(".todo-list");

function renderTodos(arr) {
    // Xóa hết nội dung đang có
    todoListEl.innerHTML = "";

    // Kiểm tra mảng có rỗng hay không
    if (arr.length == 0) {
        todoListEl.innerHTML = "Không có công việc nào trong danh sách";
        return;
    }

    // Sử dụng vòng lặp để render
    let html = ""
    for (let i = 0; i < arr.length; i++) {
        const t = arr[i];
        html += `
            <div class="todo-item ${t.status ? "active-todo" : ""}">
                <div class="todo-item-title">
                    <input
                        type="checkbox"
                        ${t.status ? "checked" : ""}
                        onclick="toggleStatus(${t.id})"
                    />
                    <p>${t.title}</p>
                </div>
                <div class="option">
                    <button class="btn btn-update" onclick="updateTitle(${t.id})">
                        <img src="./img/pencil.svg" alt="icon" />
                    </button>
                    <button class="btn btn-delete" onclick="deleteTodo(${t.id})">
                        <img src="./img/remove.svg" alt="icon" />
                    </button>
                </div>
            </div>
        `
    }
    todoListEl.innerHTML = html;
}

// Xóa công việc
async function deleteTodo(id) {
    try {
        // Gọi API xóa
        await axios.delete(`${API_URL}/todos/${id}`)

        // Xóa ở mảng ban đầu
        todos.forEach((todo, index) => {
            if (todo.id == id) {
                todos.splice(index, 1);
            }
        })

        // Sau khi xóa thì render lại giao diện
        renderTodos(todos)

    } catch (error) {
        console.log(error);
    }
}

const inputTodoEl = document.getElementById("todo-input");
const btnAdd = document.getElementById("btn-add");

btnAdd.addEventListener("click", async function () {
    try {
        // Lấy title
        let title = inputTodoEl.value;

        // Kiểm tra tiêu đề có trống hay không
        if (title == "") {
            alert("Tiều đề không được để trống")
            return
        }

        if (isUpdate) {
            // Cập nhật
            // Tìm công viêc có id = idUpdate
            let todo = todos.find((todo) => todo.id == idUpdate);

            // Gọi API
            let res = await axios.put(`${API_URL}/todos/${todo.id}`, {
                title: title,
                status: todo.status
            })

            // Cập nhật lại trong mảng todos
            todos.forEach((todo, index) => {
                if (todo.id == idUpdate) {
                    todos[index] = res.data;
                }
            });

            // Thay đổi giao diện về ban đầu
            btnAdd.innerText = "Thêm";

            // Reset lại biến sau khi đã cập nhật thành công
            isUpdate = false;
            idUpdate = null;
        } else {
            // Thêm
            // Gọi API
            let res = await axios.post(`${API_URL}/todos`, {
                title: title
            })

            // Thêm todo mới vào trong mảng todos ban đầu
            todos.push(res.data);
        }

        // Reset ô input
        inputTodoEl.value = "";

        // Hiển thị lại trên giao diện
        renderTodos(todos)

    } catch (error) {
        console.log(error);
    }
})

// Thay đổi trạng thái công việc
async function toggleStatus(id) {
    try {
        // Lấy ra công việc cần cập nhật
        let todo = todos.find(todo => todo.id == id);

        // Gọi API
        let res = await axios.put(`${API_URL}/todos/${id}`, {
            title: todo.title,
            status: !todo.status
        })

        if (res.data) {
            // Cập nhật lại todo trong mảng ban đầu
            todos.forEach(todo => {
                if (todo.id == id) {
                    todo.status = !todo.status
                }
            })

            // Render lại trên giao diện
            renderTodos(todos)
        }

    } catch (error) {
        console.log(error);
    }
}

// Lọc công việc theo trạng thái

// Truy cập vào 3 nút radio
const todoOptionItem = document.querySelectorAll(".todo-option-item input");

// Lấy giá trị trong 1 ô input radio
function getOptionSelected() {
    for (let i = 0; i < todoOptionItem.length; i++) {
        if (todoOptionItem[i].checked) {
            return todoOptionItem[i].value;
        }
    }
}

todoOptionItem.forEach((btn) => {
    btn.addEventListener("change", function () {
        let optionSelected = getOptionSelected();
        getTodos(optionSelected);
    });
});

// Cập nhật
function updateTitle(id) {
    let title;

    // Tìm kiếm công việc muốn cập nhật và lưu lại giá trị title
    todos.forEach((todo) => {
        if (todo.id == id) {
            title = todo.title;
        }
    });

    // Đổi tên "THÊM" -> "CẬP NHẬT"
    btnAdd.innerText = "CẬP NHẬT";

    // Hiển thị tiêu đề cần cập nhật lên ô input
    inputTodoEl.value = title;
    inputTodoEl.focus();

    // Lưu lại id của công việc cần cập nhật và cho phép cập nhật
    idUpdate = id;
    isUpdate = true;
}

getTodos();
