<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>마이페이지</title>
    <style>
       
        h1 {
            margin-bottom: 20px;
        }

        .user-info {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
        }

        .user-info p {
            margin: 0;
            font-size: 18px;
        }

        .section {
            margin-bottom: 40px;
        }

        .section-header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px;
            background-color:#f9f9f9;
            color: black;
        }

        .section-content {
            background-color: #f5f5f5;
            padding: 20px;
        }

        .section-content p {
            margin: 5px 0;
        }

        .btn-edit {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>

<main class="container mt-5">
    <h1>마이페이지</h1>

    <div class="container">
        <div class="user-info">
        </div>

        <!-- 회원정보 수정내역 -->
        <div class="section">
            <div class="section-header">
                <h2>회원정보 수정내역</h2>
                <button class="btn btn-warning">
                <c:if test="${logType=='U'}"><a href="/home/register/pwdChkUsers">회원정보수정</a></c:if>
            <c:if test="${logType=='M'}"><a href="/home/register/pwdChkMerchant">회원정보수정</a></c:if>
            </button>
         </div>
        </div>
     
        <!-- 주문내역 -->
        <div class="section">
            <div class="section-header">
                <h2>주문내역</h2>
                <button  class="btn btn-warning">주문내역</button>
            </div>
        </div>

        <!-- 배송조회 -->
        <div class="section">
            <div class="section-header">
                <h2>배송조회</h2>
                <button  class="btn btn-warning">배송조회</button>
            </div>
        </div>

        <!-- 구독상태 -->
        <div class="section">
            <div class="section-header">
                <h2>구독상태</h2>
            </div>
        </div>
</main>