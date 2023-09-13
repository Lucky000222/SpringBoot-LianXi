package com.security.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;


import java.net.HttpCookie;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;

public class WebV {
    public static HttpResponse requestX(String url) {
        return HttpRequest.get(url).execute();
    }
    public static HttpResponse requestX(String url, String submit) {
        HttpResponse res;
        if (submit != null) {
            res = HttpRequest.post(url).body(submit).execute();
        } else {
            res = HttpRequest.get(url).execute();
        }
        return res;
    }
    public static HttpResponse requestX(String url, String submit, String header) {
        HttpResponse res;
        if (submit != null) {
            res = HttpRequest.post(url).body(submit).addHeaders(createHeaders(header)).execute();
        } else {
            res = HttpRequest.get(url).addHeaders(createHeaders(header)).execute();
        }
        return res;
    }
    public static HttpResponse requestX(String url, String submit, String header, List<HttpCookie> cookies) {
        HttpResponse res;
        if (submit != null) {
            res = HttpRequest.post(url).body(submit).addHeaders(createHeaders(header)).cookie(cookies).execute();
        } else {
            res = HttpRequest.get(url).addHeaders(createHeaders(header)).cookie(cookies).execute();
        }
        return res;
    }
    public static HttpResponse requestX(String url, String submit, String header, List<HttpCookie> cookies, String proxy) {
        HttpResponse res ;
        try {
            if (submit != null) {
                res = HttpRequest.post(url).body(submit).addHeaders(createHeaders(header)).cookie(cookies).setProxy(creatProxy(proxy)).execute();
            } else {
                res = HttpRequest.get(url).addHeaders(createHeaders(header)).cookie(cookies).setProxy(creatProxy(proxy)).execute();
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    private static Proxy creatProxy(String proxy) {
        String host = "";
        int port = 0;
        if (proxy != null && proxy.contains(":")) {
            String[] sp = proxy.split(":");
            if (sp.length == 2) {
                host = sp[0];
                port = Integer.parseInt(sp[1]);
            }
        }
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
    }
    private static HashMap<String, Object> from(String submit) {
        HashMap<String, Object> paramMap = new HashMap<>(0);
        if (submit != null) {
            if (submit.contains("=")) {
                submit = submit.replaceAll(" ", "");
                String[] split = submit.split("&");
                for (String s : split) {
                    String[] split1 = s.split("=");
                    if (split1.length == 1) {
                        paramMap.put(split1[0], "");
                    } else {
                        paramMap.put(split1[0], split1[1]);
                    }
                }
            }
            if (submit.contains("{\"")) {
                submit = submit.replaceAll(" ", "");
                submit = submit.replaceAll("\"", "");
                submit = txt.rmtext_Max(submit, "{", "}");
                String[] split = submit.split(",");
                for (String s : split) {
                    String[] split1 = s.split(":");
                    if (split1.length == 1) {
                        paramMap.put(split1[0], "");
                    } else {
                        paramMap.put(split1[0], split1[1]);
                    }
                }
            }
        }
        return paramMap;
    }
    private static HashMap<String, String> createHeaders(String header) {
        HashMap<String, String> hasHeader = new HashMap<>(0);
        if (header != null) {
            header = header.replaceAll(" ", "");
            String[] sp1 = header.split("\n");
            for (String s : sp1) {
                String[] sp2 = s.split(":");
                if (sp2.length == 2) {
                    hasHeader.put(sp2[0], sp2[1]);
                }
            }
        }
        return hasHeader;
    }
}
