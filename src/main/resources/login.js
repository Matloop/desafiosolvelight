document.addEventListener('DOMContentLoaded', () => {

    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');

    async function register(userName, password) {
        const body = { name: userName, password: password };
        try {
            const response = await fetch('http://localhost:8080/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(body)
            });
            const data = await response.text();
            console.log(data);
        } catch (error) {
            console.log('Erro ao registrar usuário', error);
        }
    }

    async function login(userName, password) {
        const body = { name: userName, password: password };
        try {
            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(body)
            });
            const data = await response.text();
            console.log(data);
            if (data === "Login feito com sucesso") {
                window.location.href = "index.html";
            }
        } catch (error) {
            console.log('Erro ao fazer login', error);
        }
    }

    document.getElementById('register-btn').addEventListener('click', () => {
        const userName = usernameInput.value.trim();
        const password = passwordInput.value;
        register(userName, password);
    });

    document.getElementById('login-btn').addEventListener('click', () => {
        const userName = usernameInput.value.trim();
        const password = passwordInput.value;
        login(userName, password);
    });

});
