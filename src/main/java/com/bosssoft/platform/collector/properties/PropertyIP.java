package com.bosssoft.platform.collector.properties;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.platform.collector.Constants;



public class PropertyIP implements ServerProperty{
	
	private static Logger log = LoggerFactory.getLogger(PropertyIP.class);
	
	private String errorMessage;

	public String propertyName() {
		
		return Constants.PROPERTY_NAME_IP;
	}

	/*public String propertyValue() {
		//System.out.println("start get ip info.........");
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		try {
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
	        InetAddress ip = null;
	        boolean isFound = false;// 是否找到外网IP
	        while (netInterfaces.hasMoreElements() && !isFound) {
	            NetworkInterface ni = netInterfaces.nextElement();
	            Enumeration<InetAddress> address = ni.getInetAddresses();
	            while (address.hasMoreElements()) {
	                ip = address.nextElement();
	                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
	                    netip = ip.getHostAddress();
	                    isFound = true;
	                    break;
	                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
	                    localip = ip.getHostAddress();
	                }
	            }
	        }

	        if (netip != null && !"".equals(netip)) {
	        	//log.info("get IP info end,ip:"+netip);
	            return netip;
	        } else {
	        	//log.info("get IP info end,ip:"+localip);
	            return localip;
	        }
		} catch (SocketException se) {
			errorMessage="get ip info fail";
			log.error("get ip info fail "+se.toString());
			return "";
		}
		
	}*/
	
	public String propertyValue() {
        Set<String> ipSet=new HashSet<>();
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean isFound = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !isFound) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        ipSet.add(ip.getHostAddress());
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        ipSet .add(ip.getHostAddress());
                    }
                }
            }

           // System.out.println(ipSet);
           return StringUtils.join(ipSet, ",");
        } catch (SocketException se) {
            errorMessage="get ip info fail";
            log.error("get ip info fail "+se.toString());
            return "";
        }
        
    }

	public String getErrorMessage() {
		
		return errorMessage;
	}

}
