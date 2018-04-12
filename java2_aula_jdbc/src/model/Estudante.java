package model;

import java.util.Date;

public class Estudante {
   private int estudante_id;
   private String nome;
   private String curso;
   private Date data_matricula;
   private String status;

   public int getEstudante_id() {
       return estudante_id;
   }

   public void setEstudante_id(int estudante_id) {
       this.estudante_id = estudante_id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getCurso() {
       return curso;
   }

   public void setCurso(String curso) {
       this.curso = curso;
   }

   public Date getData_matricula() {
       return data_matricula;
   }

   public void setData_matricula(Date data_matricula) {
       this.data_matricula = data_matricula;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }

  
   
}
