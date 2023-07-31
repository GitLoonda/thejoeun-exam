const signup = document.getElementById("signUpBtn");
if(signup) {
    signup.addEventListener('click', event => {
        let email = document.getElementById('email').value;
        let password = document.getElementById('password').value;

        fetch('/api/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
        .then(data => data.json())
        .then(data => {
            if(data.email === email) {
                alert("회원가입에 성공하였습니다.");
                location.replace('/login');
            }
            else {
                return alert("회원가입에 실패하였습니다.");
            }
        })
    })
}

const login = document.getElementById("loginBtn");
if(login) {
    login.addEventListener('click', event => {
        let email = document.getElementById('email').value;
        let password = document.getElementById('password').value;

        fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
        .then(data => data.json())
        .then(data => {
            if(data.email === email) {
                alert("로그인에 성공하였습니다.");
                location.replace('/');
            }
            else {
                return alert("로그인에 실패하였습니다.");
            }
        })
    })
}