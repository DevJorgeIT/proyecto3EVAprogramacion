/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author AluDAM
 */
public class Usuario implements Serializable{
    private String nick;
    private String password;
    private String email;
    private String telefono;
    private Boolean enviar;

    public Usuario(String nick, String password, String email, String telefono, Boolean enviar) {
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.enviar = enviar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEnviar() {
        return enviar;
    }

    public void setEnviar(Boolean enviar) {
        this.enviar = enviar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "Usuario{" + "nick=" + nick + ", password=" + password + ", email=" + email + ", telefono=" + telefono + ", enviar=" + enviar + '}';
    }
    
    
    
}
