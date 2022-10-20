package com.security.controller;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.http.HttpResponse;
import com.security.account.Account;
import com.security.utils.xiao16.core.text.txt;
import com.security.utils.xiao16.core.web_v.WebV;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController()
@RequestMapping("Login")
public class HelloController {

    @Autowired
    private Account account;
    static final String hihi = "%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8D%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8C%E2%80%8E%E2%80%8B%E2%80%8E%E2%80%8B";

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // 基本信息  老版本
    @GetMapping("loginTui")
    public StringBuilder loginTui() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> userOrPassword = account.Account();
        double balanceCount = 0.00;
        int ipgCount = 0;

        for (String s : userOrPassword.keySet()) {
            boolean boo = false;
            HttpResponse respUser = WebV.requestX("http://tul.xinyaoxie.cn/data/api.login/in", "phone=" + s + "&password=" + userOrPassword.get(s) + "&time=" + System.currentTimeMillis() + "&sign=40BC7FDCEBB1DA323162AF17A42F17BF&hihi=" + hihi);
            String token = txt.rmtext_Min(respUser.body(), "token\":\"", "\"}}");
            HttpResponse respList = WebV.requestX("http://tul.xinyaoxie.cn/data/api.auth.collection/getUserCollection1?limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=D5B49D477F319DCE4F9994221D7E5C54&hihi=" + hihi, null, "api-token: " + token);
            List<String> respIdList = txt.rmtext_List(respList.body(), "collection_id\":", ",\"uui");
//            System.out.println("图片类别id:  " + respIdList);
            HashMap<String, Object> hashMap = new HashMap<>();
            assert respIdList != null;

            for (String s1 : respIdList) {
                HttpResponse jpgList = WebV.requestX(" http://tul.xinyaoxie.cn/data/api.auth.collection/getInfo1?collection_id=" + s1 + "&limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=1216CB332AEF8DD53118792BCFB5D2D2&hihi=", null, "api-token: " + token);
//                System.out.println(jpgList.body());
                List<String> list = txt.rmtext_List(jpgList.body(), "l,\"status\":", ",\"type\":1,");
                int consignment = 0;
                int NotConsignment = 0;
                assert list != null;
                for (String s2 : list) {
                    if (Integer.parseInt(s2) == 1) {
                        NotConsignment++;
                    } else if (Integer.parseInt(s2) == 4) {
                        consignment++;
                    }
                }
                HttpResponse balanceResp = WebV.requestX("http://tul.xinyaoxie.cn/data/api.auth.center/get", "time=" + System.currentTimeMillis() + "&sign=11FF833F2ED831922AC28C7122B06388&hihi=" + hihi, "api-token: " + token);
                String balance = txt.rmtext_Min(balanceResp.body(), "balance\":\"", "\",\"status");
                if (!boo) {
                    if (s.equals("15806629717") || s.equals("18757467913") || s.equals("17698234973")) {
                        NotConsignment++;
                        boo = true;
                    }
                }
                int counnt = NotConsignment + consignment;
                hashMap.put("账号：" + s, "未寄售个数:  " + NotConsignment + ", 寄售个数:  " + consignment + ", 钱包余额为:  " + balance + ", 图片一共有: " + counnt);
                ipgCount += counnt;
                assert balance != null;
                balanceCount += Double.parseDouble(balance);
            }
            for (String s3 : hashMap.keySet()) {
//                System.out.println("[" + s3 + hashMap.get(s3) + "] ");
                sb.append("<p>").append("[").append(s3).append(hashMap.get(s3)).append("] ").append("\n\n").append("</p>");
            }
        }                              // new DecimalFormat("#.00").format(balanceCount)
      /*  System.out.println("总余额为:  " + String.format("%.2f", balanceCount));
        System.out.println("总图片为:  " + ipgCount);*/
        sb.append("<p>").append("总余额为:  ").append(String.format("%.2f", balanceCount)).append("\n\n").append("</p>");
        sb.append("<p>").append("总图片为:  ").append(ipgCount).append("\n\n").append("</p>");
        return sb;
    }

    // 基本信息
    @GetMapping("LoginTui")
    public StringBuilder LoginTui() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> userOrPassWord = account.Account();
        double balanceCount = 0.00;
        int ipgCount = 0;
        for (String s : userOrPassWord.keySet()) {
            boolean boo = false;
            HttpResponse respUser = WebV.requestX("http://tul.xinyaoxie.cn/data/api.login/in", "phone=" + s + "&password=" + userOrPassWord.get(s) + "&time=" + System.currentTimeMillis() + "&sign=40BC7FDCEBB1DA323162AF17A42F17BF&hihi=" + hihi);
            String token = txt.rmtext_Min(respUser.body(), "token\":\"", "\"}}");
//            HttpResponse respList = WebV.requestX("http://tul.xinyaoxie.cn/data/api.auth.collection/getUserCollection1?limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=D5B49D477F319DCE4F9994221D7E5C54&hihi=" + hihi, null, "api-token: " + token);
//            List<String> respIdList = txt.rmtext_List(respList.body(), "collection_id\":", ",\"uui");
//            System.out.println("图片类别id:  " + respIdList);
            HashMap<String, Object> hashMap = new HashMap<>();
            int[] collectionId = {29, 31};   // 图片类别id 29神龙 31玄武
            int longConsignment = 0;      // 神龙寄售
            int xuanwuConsignment = 0;    // 玄武寄售
            int notLongConsignment = 0;   // 神龙未寄售
            int notXuanwuConsignment = 0; // 玄武未寄售
            for (int i : collectionId) {
                HttpResponse jpgListA = WebV.requestX(" http://tul.xinyaoxie.cn/data/api.auth.collection/getInfo1?collection_id=" + i + "&limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=1216CB332AEF8DD53118792BCFB5D2D2&hihi=", null, "api-token: " + token);
                List<String> listA = txt.rmtext_List(jpgListA.body(), "l,\"status\":", ",\"type\":1,");
                assert listA != null;
                for (String s2 : listA) {
                    if (Integer.parseInt(s2) == 1) {
                        if (i == 29){
                            notLongConsignment++;
                        }else {
                            notXuanwuConsignment++;
                        }
                    } else if (Integer.parseInt(s2) == 4) {
                        if (i == 29){
                            longConsignment++;
                        }else {
                            xuanwuConsignment++;
                        }
                    }
                }
            }
            //获取个人信息，拿余额
            HttpResponse balanceResp = WebV.requestX("http://tul.xinyaoxie.cn/data/api.auth.center/get", "time=" + System.currentTimeMillis() + "&sign=11FF833F2ED831922AC28C7122B06388&hihi=" + hihi, "api-token: " + token);
            String balance = txt.rmtext_Min(balanceResp.body(), "balance\":\"", "\",\"status");

            assert balance != null;
            balanceCount += Double.parseDouble(balance);
            int counntA = notLongConsignment + longConsignment;  // 神龙未寄售和寄售的总和
            int counntB = notXuanwuConsignment + xuanwuConsignment;  // 玄武未寄售和寄售的总和
            ipgCount += counntA + counntB;                        //每个账户图片的总和
/*            hashMap.put("账号:  " + s, ", 木之神龙有:  " + counntA + ", 未寄售个数:  " + notLongConsignment + ", 寄售个数:  " + longConsignment + ", 水玄武圣有:  " + counntB + ", 未寄售个数:  " + notXuanwuConsignment + ", 寄售个数:  " + xuanwuConsignment + ", 钱包余额为:  " + balance + ", 图片一共有: " + (counntA + counntB));
            for (String s3 : hashMap.keySet()) {
//                System.out.println("[" + s3 + hashMap.get(s3) + "] ");
                sb.append("<p>").append("[").append(s3).append(hashMap.get(s3)).append("] ").append("\n\n").append("</p>");
            }*/
//            String number = s.substring(0,3) + "****" + s.substring(7,11);
            sb.append("<p>").append("[").append("&nbsp").append("账号:  ").append(DesensitizedUtil.mobilePhone(s)).append("&nbsp").append(", 木之神龙有:  ").append(counntA).append("&nbsp")
                    .append(", 未寄售个数:  ").append(notLongConsignment).append("&nbsp").append(", 寄售个数:  ").append(longConsignment).append(",").append("</p>")
                    .append("<p>").append("水玄武圣有:  ").append(counntB).append("&nbsp").append(", 未寄售个数:  ").append(notXuanwuConsignment)
                    .append("&nbsp").append(", 寄售个数:  ").append(xuanwuConsignment).append("&nbsp").append(", 钱包余额为:  ").append(balance)
                    .append("&nbsp").append(", 图片一共有: ").append(counntA + counntB).append("&nbsp").append("]").append("\n\n").append("</p>").append("<br/>");

        }                                         // new DecimalFormat("#.00").format(balanceCount)
        sb.append("<p>").append("总余额为:  ").append(String.format("%.2f", balanceCount)).append("\n\n").append("</p>");
        sb.append("<p>").append("总图片为:  ").append(ipgCount).append("\n\n").append("</p>");
        sb.append("<a href=").append("https://360a122i46.eicp.vip/Login/consignment").append(">").append("自己人寄售情况").append("&nbsp&nbsp&nbsp")
                .append("<a href=").append("https://360a122i46.eicp.vip/Login/othersConsignment").append(">").append("别人寄售情况").append("</a>").append("<br/>").append("<br/>");

        return sb;
    }

    // 自己人寄售的情况
    @GetMapping("consignment")
    public StringBuilder consignment() {
        HashMap<String, String> userOrPassWord = account.Account();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(29, "avatatvs6uzozf2dfidlgiiqafr0qo7s");  // 神龙的哈希
        hashMap.put(31, "avatapptowmta2eoxolohf5q02wdfoza");  // 玄武的哈希
        StringBuilder sb = new StringBuilder();
        List<Double> allList = new ArrayList<>();
        // 图片类别数组
        int[] collectionId = {29, 31};
        for (int i : collectionId) {
            // 图片总数
            int count = 0;
            for (String s : userOrPassWord.keySet()) {
                HttpResponse respUser = WebV.requestX("http://tul.xinyaoxie.cn/data/api.login/in", "phone=" + s + "&password=" + userOrPassWord.get(s) + "&time=" + System.currentTimeMillis() + "&sign=40BC7FDCEBB1DA323162AF17A42F17BF&hihi=" + hihi);
                String token = txt.rmtext_Min(respUser.body(), "token\":\"", "\"}}");
                HttpResponse jpgList = WebV.requestX(" http://tul.xinyaoxie.cn/data/api.auth.collection/getInfo1?collection_id=" + i + "&limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=1216CB332AEF8DD53118792BCFB5D2D2&hihi=", null, "api-token: " + token);
                List<String> status4List = txt.rmtext_List(jpgList.body(), "status\":4,\"type\":1,\"hash\":\"" + hashMap.get(i) + "\",\"order_no\":\"", "\",\"price");
                List<Double> status4ListResp = new ArrayList<>();
                if (status4List != null) {
                    status4List.forEach(s2 -> {
                        if (s2 != null || !s2.equals("")) {
                            String s3 = txt.rmtext_Min(jpgList.body(), s2 + "\",\"price\":\"", "\",\"tokenId");
                            status4ListResp.add(Double.valueOf(s3));
                        }
                    });
                }
                Collections.sort(status4ListResp);
                allList.addAll(status4ListResp);
                count += status4ListResp.size();
                if (i == 29) {
                    sb.append("账号: ").append(DesensitizedUtil.mobilePhone(s)).append(", 寄售的木之神龙价格根据排序是: ").append(status4ListResp).append("<br/>").append("<br/>");
                } else {
                    sb.append("账号: ").append(DesensitizedUtil.mobilePhone(s)).append(", 寄售的水玄武圣价格根据排序是: ").append(status4ListResp).append("<br/>").append("<br/>");
                }
            }
            sb.append("一共寄售: ").append(count).append("个").append("<br/>").append("<br/>");
            List<Double> doubles = new ArrayList<>(allList);
            Collections.sort(doubles);
            sb.append("自己人挂的价格，价格升序:  ").append(doubles).append("<br/>").append("<br/>");
        }
        sb.append("<a href=").append("https://360a122i46.eicp.vip/Login/LoginTui").append(">").append("账号基本情况").append("&nbsp&nbsp&nbsp")
                .append("<a href=").append("https://360a122i46.eicp.vip/Login/othersConsignment").append(">").append("别人寄售情况").append("</a>").append("<br/>").append("<br/>");
        return sb;
    }

    // 别人寄售情况
    @GetMapping("othersConsignment")
    public StringBuilder othersConsignment(){
        HashMap<String, String> userOrPassWord = account.Account();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        String token = null;
        // 图片类别数组
        int[] collectionId = {29, 31};
        for (int id : collectionId) {
            if (id == 29){
                sb.append("<font color=\"red\">").append("木之神龙寄售: ").append("</font>").append("<br/>").append("<br/>");
            }else {
                sb.append("<font color=\"red\">").append("水玄武圣寄售: ").append("</font>").append("<br/>").append("<br/>");
            }
            for (String s : userOrPassWord.keySet()) {
                HttpResponse respUser = WebV.requestX("http://tul.xinyaoxie.cn/data/api.login/in", "phone=" + s + "&password=" + userOrPassWord.get(s) + "&time=" + System.currentTimeMillis() + "&sign=40BC7FDCEBB1DA323162AF17A42F17BF&hihi=" + hihi);
                token = txt.rmtext_Min(respUser.body(), "token\":\"", "\"}}");
                // 自己人所有图片的sellId
                HttpResponse jpgList = WebV.requestX(" http://tul.xinyaoxie.cn/data/api.auth.collection/getInfo1?collection_id=" + id + "&limit=15&page=1&time=" + System.currentTimeMillis() + "&sign=1216CB332AEF8DD53118792BCFB5D2D2&hihi=", null, "api-token: " + token);
                String sellIdFirst = txt.rmtext_Min(jpgList.body(), "data\":[{\"id\":", ",\"collection_id\":" + id + ",\"u");
                list.add(sellIdFirst);
                List<String> list1 = txt.rmtext_List(jpgList.body(), "\\,\\{\"id\":", "\\,\"collection_id");
                assert list1 != null;
                list.addAll(list1);
            }
            // 自己人所有图片的sellId
            System.out.println(list);
            System.out.println(list.size());

            HttpResponse httpResponse = WebV.requestX("http://tul.xinyaoxie.cn/data/api.auth.mark/getUserMark?limit=15000&page=1&type=1&goods_id=" + id + "&sort=2&name=&time=1665850892700&sign=46DF8488A2F60524FE8532323E6634B5&hihi=" + hihi, null, "api-token: " + token);
            System.out.println(httpResponse.body());
            // 市场寄售的所有图片
            List<String> list1 = txt.rmtext_List(httpResponse.body(), "\"sell_id\":", ",\"goods_id\":" + id);
            assert list1 != null;
            sb.append("寄售的一共有: ").append(list1.size()).append("<br/>").append("<br/>");
            ArrayList<Object> arrayList = new ArrayList<>();
            list1.forEach(s -> {
                if (!list.contains(s)) {
                    arrayList.add(s);
                }
            });
            sb.append("别人的有: " ).append(arrayList.size()).append("<br/>").append("<br/>");
            List<String> list2 = new ArrayList<>();
            arrayList.forEach(s -> {
                String respString = txt.rmtext_Min(httpResponse.body(), "sell_id\":" + s + ",\"goods_id\":" + id + ",\"status\":1,\"price\":\"", "\",\"type\":1");
                if (respString != null && !respString.equals("")) {
                    list2.add(respString);
                }
            });
            Collections.sort(list2);
            double moneyNum = 0.00;
            double moneyNum500 = 0.00;
            int ipgNumCount = 0;
            for (String s : list2) {
                moneyNum += Double.parseDouble(s);
                if (Double.parseDouble(s) <= 500) {
                    moneyNum500 += Double.parseDouble(s);
                    ipgNumCount++;
                }
            }
            sb.append("别人寄售的图片的价格:  ").append(list2).append("<br/>").append("<br/>");
            sb.append("别人寄售的图片的总数:  " ).append(list2.size()).append("<br/>").append("<br/>");
            sb.append("需要扫光别人所有图片的金额是:  ").append(moneyNum).append("<br/>").append("<br/>");
            sb.append("需要扫光别人500元以下图片的金额是:  ").append(moneyNum500).append("<br/>").append("<br/>");
            sb.append("别人500元以下图片的总数是:  ").append(ipgNumCount).append("<br/>").append("<br/>").append("<br/>").append("<br/>");
        }
        sb.append("<a href=").append("https://360a122i46.eicp.vip/Login/LoginTui").append(">").append("账号基本情况").append("&nbsp&nbsp&nbsp")
                .append("<a href=").append("https://360a122i46.eicp.vip/Login/consignment").append(">").append("自己人寄售情况").append("</a>").append("<br/>").append("<br/>");
        return sb;
    }
}
