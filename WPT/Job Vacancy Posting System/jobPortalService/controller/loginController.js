
const connection = require('../databaseConfig/databaseConfig')
const { generateToken } = require("../middleware/jwtconfig")

exports.validateUser = (req, resp) => {
    const { email, password } = req.body;

    if (!email || !password) {
        return resp.status(400).json({ message: "Email and password required" });
    }

    connection.query(
    "SELECT * FROM admin WHERE email=?", 
    [email], 
    (error, result) => {

        if (error) {
            console.log("MYSQL ERROR → ", error);
            return resp.status(500).json({ message: "DB error" });
        }

            if (result.length === 0) {
                return resp.status(404).json({ message: "User not found" });
            }
            const user = result[0];

            if (user.password !== password) {
                return resp.status(401).json({ message: "Invalid password" });
            }

            const token = generateToken(user);

            return resp.status(200).json({
                message: "Login Successfull!",
                token,
                user: {
                    id: user.admin_id,
                    name: user.email
                }
            })
        }

    )
}