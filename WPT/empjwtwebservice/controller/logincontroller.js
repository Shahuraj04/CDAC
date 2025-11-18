const connection = require("../databaseconfig/databaseconfig");
const { generateToken } = require("../middleware/jwtInfo");

exports.validateuser = (req, resp) => {
    const { email, password } = req.body;

    if (!email || !password) {
        return resp.status(400).json({ message: "Email and password required" });
    }

    connection.query(
        "SELECT * FROM emp_data WHERE email = ?",
        [email],
        (err, result) => {

            // 🔥 If MySQL gives any error, show it in console
            if (err) {
                console.log("MYSQL ERROR → ", err);
                return resp.status(500).json({ message: "DB error" });
            }

            // ❗ If no user found
            if (result.length === 0) {
                return resp.status(404).json({ message: "User not found" });
            }

            const user = result[0];

            // ❗ Password match check (plain text)
            if (user.password !== password) {
                return resp.status(401).json({ message: "Invalid password" });
            }

            // 🔥 Generate JWT token
            const token = generateToken(user);

            return resp.status(200).json({
                message: "Login successful",
                token,
                user: {
                    id: user.empId,
                    name: user.empname,
                    email: user.email,
                    role: user.role
                }
            });
        }
    );
};
