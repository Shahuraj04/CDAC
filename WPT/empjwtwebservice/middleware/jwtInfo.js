const jwt = require("jsonwebtoken");
const JWT_SECRET = "mysecretkey";

exports.generateToken = (user) => {
    const payload = {
        id: user.empId,
        ename: user.empname,
        email: user.email,
        role: user.role
    };

    return jwt.sign(payload, JWT_SECRET, { expiresIn: "2h" });
};

exports.authenticateToken = (req, resp, next) => {
    const auth = req.headers.authorization;

    if (!auth || !auth.startsWith("Bearer ")) {
        return resp.status(401).json({ message: "Missing token" });
    }

    const token = auth.split(" ")[1];

    try {
        const payload = jwt.verify(token, JWT_SECRET);
        req.user = payload;
        next();
    } catch (err) {
        return resp.status(401).json({ message: "Invalid or expired token" });
    }
};
