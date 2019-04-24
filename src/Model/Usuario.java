package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
@SequenceGenerator(name="seq_usua", initialValue=1)// comando para criar uma sequencia propria para a tabela atual.

public class Usuario extends Model implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String senha;
    private String email;

    public Usuario() {
    }

    public Usuario(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", email=" + email + '}';
    }
    
    
    
    
    
}
