package br.edu.iff.pooa20152.ssl_suplementos.domain;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by sebastiao on 14/05/16.
 */
    public class ClienteService extends GenericService {

        public ClienteService(String url, String id, String method, JSONObject params) {
            super(url, id, method, params,new Cliente());
        }
        public ClienteService(){
            super();
        }

        public List<Cliente> getAll(String url) {

            List<Cliente> listaClientes = super.getAll(url,new Cliente());

            return listaClientes;

        }

        public Cliente doGet(String url,String id){

            return (Cliente) super.doGet(url,id,new Cliente());
        }

        public Cliente doDelete(String url,String id){

            return (Cliente) super.doDelete(url,id);
        }

        public Cliente doPut(String url, JSONObject params){
            return (Cliente) super.doPut(url,params,new Cliente());
        }

        public Cliente doPost(String url, JSONObject params){
            return (Cliente) super.doPost(url,params,new Cliente());
        }

        public Cliente execute(){
            return (Cliente) super.execute();
        }
    }

