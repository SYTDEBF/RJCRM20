package server;

import domian.Admin;
import domian.Custom;

public interface AdminServer {
     Admin findByNameAndPass(String admin_name, String admin_password);
}
