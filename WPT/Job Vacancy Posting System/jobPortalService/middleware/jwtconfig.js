const jwt = require("jsonwebtoken");

const JWT_SECRET  = "mysecretkey";

exports.generateToken=(user)=>{

    const payload = {
        admin_id : user.admin_id,
        email : user.email,
        password : user.password,
    };
    return jwt.sign(payload,JWT_SECRET,{expiresIn:"2h"})

}

exports.validateToken=(req,resp,next)=>{
    const auth = req.headers.authorization;

    if(!auth || !auth.startswith("Bearer ")){
        return resp.status(401).json({message:"Missing token"})

    }
    const token = auth.split(" ")[1];

    try {
        const payload=jwt.verify(token,JWT_SECRET)
        req.user=payload;
        next();
    } catch (error) {
        return resp.status(401).json({ message: "Invalid or expired token" });
    }

}