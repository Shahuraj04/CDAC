    import React, { useState } from "react";
    import img1 from "../assets/login_page/login.jpg";
    import 'bootstrap/dist/css/bootstrap.min.css';
    import { useNavigate } from "react-router-dom";
    import empSevice from "../service/empService"


    export default function LoginPage() {
        const navigate = useNavigate();
        const [loginDetails, setLoginDetails] = useState({ email: "", password: "" });

        const handleChange = (event) => {
            var { name, value } = event.target;
            setLoginDetails({ ...loginDetails, [name]: value })
        }

        const login = (e) => {
            e.preventDefault();
            empSevice.adminLogin(loginDetails).then((result) => {
                navigate("/emptable")
            }).catch((err) => {
                console.log(err)
            })

        }
        return (
            <div className="container mt-4">
                <form>

                    <div className="form-group">
                        <label htmlFor="exampleInputEmail1">Email address</label>
                        <input
                            type="email"
                            className="form-control"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                            name="email"
                            value={loginDetails.email}
                            onChange={handleChange}
                        />
                        <small id="emailHelp" className="form-text text-muted">
                            We'll never share your email with anyone else.
                        </small>
                    </div>

                    <div className="form-group">
                        <label htmlFor="exampleInputPassword1">Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="exampleInputPassword1"
                            name="password"
                            value={loginDetails.password}
                            onChange={handleChange}
                        />
                    </div>

                    <br />
                    <button type="submit" className="btn btn-primary" onClick={login}>
                        Submit
                    </button>

                </form>
            </div>
        );
    }
