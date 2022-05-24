package com.oneframe.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MachineUtils {
  
  private MachineUtils() {
    throw new AssertionError("Cant instantiate " + MachineUtils.class.getSimpleName());
  }

  /**
   * Get machine ip address.
   *
   * @return - IP address of a machine.
   * @throws UnknownHostException - if in case of finding any unknows host.
   * @author Sudheer.Singh
   */
  public static String getMachineIpAaddress() throws UnknownHostException {
    InetAddress inetAddress = InetAddress.getLocalHost();
    return inetAddress.getHostAddress();
  }
}
