package br.edu.iff.pooa20152.ssl_suplementos.domain;

/**
 * Created by sebastiao on 14/05/16.
 */
public class Cliente {
        private Integer id;
        private String nome;
        private String endereco;
        private String telefone;
        private String email;

        public Cliente(Integer id, String nome, String endereco, String telefone, String email) {
            this.id = id;
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
        }

        public Cliente() {

        }
        public Integer getId(){
            return id;
        }
        public void setId(Integer id){
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }



        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    '}';
        }
}
