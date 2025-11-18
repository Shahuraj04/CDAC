const express = require("express")
const connection = require("../databaseconfig/databaseconfig")
const {generateToken} = require("../middleware/jwtInfo")

exports.validateuser=(req,resp)=>{
    const {email,password} = req.body
    connection.query("select * from express_emp where email=?",[email],(err,result)=>{
        if(err){
            resp.status(500).json({message:"Invalid credentials"})
        }else{
            const user = result[0];
            if(user.password===password){
                const token  = generateToken(user);
                resp.json({token})
            }else{
                resp.status(500).json({message:"Invalid credentials"})
            }
        }
    })
}