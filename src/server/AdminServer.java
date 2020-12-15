package server;

import domain.Admin;

public interface AdminServer {
     Admin findByNameAndPass(String admin_name, String admin_password);
}
