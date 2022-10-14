package com.example.reto_3.service;

import com.example.reto_3.entities.Category;
import com.example.reto_3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){return (List<Category>) categoryRepository.getAll();}
    public Optional<Category> getCategory(int categoryId){return categoryRepository.getCategory(categoryId);}
    public Category save(Category category){
        if(category.getIdCategory()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> e = categoryRepository.getCategory(category.getIdCategory());
            if(e.isEmpty()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }
    public Category update(Category category){
        if(category.getIdCategory()!=null){
            Optional<Category> q = categoryRepository.getCategory(category.getIdCategory());
            if(q.isEmpty()){
                if(category.getName()!=null){
                    q.get().setName(category.getName());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isEmpty()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
