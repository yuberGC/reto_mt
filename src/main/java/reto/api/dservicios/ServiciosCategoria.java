/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.dservicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.api.amodelos.Categoria;
import reto.api.crepositorio.RepositorioCategoria;

/**
 *
 * @author yg_cr
 */
@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> data = metodosCrud.getCategoria(categoria.getId());
            if (data.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }
    
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>datos=metodosCrud.getCategoria(categoria.getId());
            if(!datos.isEmpty()){
                if(categoria.getDescription()!=null){
                    datos.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    datos.get().setName(categoria.getName());
                }
                return metodosCrud.save(datos.get());
            }
        }
        return categoria;
    }
    public boolean deleteCategoria(int categoriaId){
        Boolean data=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return data;
    }
}
