package loja.jogos;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Arquivo {

    public static void ImportarJSON(String filename) throws FileNotFoundException{ 
        
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(filename))
        {
            Object obj = jsonParser.parse(reader);
            
            JSONArray prodList = (JSONArray) obj;
            
            int n = prodList.size();
            for (int i = 0; i < n; i++) {

                JSONObject prod = (JSONObject) prodList.get(i);

                Produtos item = toProduto(prod);

                MetodosLoja.adicionarProduto(item);

            }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static Produtos toProduto(JSONObject produto) 
    {   

        JSONObject produtoObj = (JSONObject) produto.get("produto");
         
        String nome = (String) produtoObj.get("nome");    

        String desc = (String) produtoObj.get("desc");  
         
        Double preco = (Double) produtoObj.get("preco");    

        long quantL = (long) produtoObj.get("quant");    

        int quant = (int)quantL;

        Produtos item = new Produtos(nome, desc, preco, quant);

        return item;
    }
    
}
