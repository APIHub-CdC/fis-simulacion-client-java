package io.fis.simulacion.mx.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;


public class Respuesta {

  @SerializedName("scoreNoHit")
  private Object scoreNoHit = null;
  @SerializedName("folioConsulta")
  private String folioConsulta = null;

  
  
  public Respuesta scoreNoHit(Object scoreNoHit) {
    this.scoreNoHit = scoreNoHit;
    return this;
  }
   
  @ApiModelProperty(value = "Score FIS")
  public Object getScoreNoHit() {
    return scoreNoHit;
  }
  public void setScoreNoHit(Object scoreNoHit) {
    this.scoreNoHit = scoreNoHit;
  }
  public Respuesta folioConsulta(String folioConsulta) {
    this.folioConsulta = folioConsulta;
    return this;
  }
   
  @ApiModelProperty(example = "7544569", value = "Folio de consulta")
  public String getFolioConsulta() {
    return folioConsulta;
  }
  public void setFolioConsulta(String folioConsulta) {
    this.folioConsulta = folioConsulta;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Respuesta respuesta = (Respuesta) o;
    return 
        Objects.equals(this.scoreNoHit, respuesta.scoreNoHit) &&
        Objects.equals(this.folioConsulta, respuesta.folioConsulta);
  }
  @Override
  public int hashCode() {
    return Objects.hash(scoreNoHit, folioConsulta);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
    sb.append("    scoreNoHit: ").append(toIndentedString(scoreNoHit)).append("\n");
    sb.append("    folioConsulta: ").append(toIndentedString(folioConsulta)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
