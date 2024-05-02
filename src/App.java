import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    private static List<producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            try{
                System.out.println("---------INVENTARIO-----------");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Agregar producto");;
                System.out.println("2. Eliminar Producto");
                System.out.println("3. Buscar producto");
                System.out.println("4. Salir");
                System.out.println("-----------------------------");
            
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (opcion) {
                    case 1:
                        insertarProducto();
                        break;
                    case 2:
                        eliminarProducto();
                        break;
                    case 3:
                        buscarProductoPorNombre();
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            }catch(InputMismatchException e){
                System.out.println("mira sopeton, ingresa un numero de pero no palabras. ");
                scanner.next();
            }    
        }
        scanner.close();
    }
    
    private static void insertarProducto() {
        boolean datoCorrecto = false;
        String nombre = "";
        int id = 0;
        double valor = 0;
        int cantidad = 0;
       
        do{
          try{ 
            System.out.println("-----------------------------------");
            System.out.println("Ingrese el nombre del producto:");
            nombre = scanner.nextLine();
            
            System.out.println("Ingrese ID del producto: ");
            id = Integer.parseInt(scanner.nextLine());

            if(id<=0){
                throw new IllegalArgumentException("El ID del producto debe ser mayor oiguala cero,");
            }

            System.out.println("Ingrese valor del producto: ");
            valor =Double.parseDouble(scanner.nextLine());
            
            if(valor<0){
                throw new IllegalArgumentException("el valor del producto debe ser un valor mayor o igual a 0 $");
            }

            System.out.println("Ingrese la cantidad: ");
            cantidad = Integer.parseInt(scanner.nextLine());
            
            if(cantidad <=0){
                throw new IllegalArgumentException("la cantidad debe ser mayor que cero");
            }
            System.out.println("-----------------------------------");
            
            datoCorrecto= true;

        }catch(NumberFormatException e){
            System.out.println("debes digitar un numero entero");
            scanner.nextLine();
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        }
    }while(!datoCorrecto);
    producto producto = new producto(nombre, id, valor, cantidad);
    productos.add(producto);
    System.out.println("producto guardado correctamente.");

    }

private static void buscarProductoPorNombre() {
    try{
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        boolean productoEncontrado = false;
        for (producto producto : productos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                System.out.println("-----------------------------------");
                System.out.println("producto encontrado:");
                System.out.println("Id del producto: " + producto.getIdProducto());
                System.out.println("Nombre: " + producto.getNombreProducto());
                System.out.println("valor: " + producto.getValor() + "$");
                System.out.println("-----------------------------------");
                productoEncontrado = true;
                break;
            }
        }
        if (!productoEncontrado) {
            throw new ProductNotFoundExeception("producto no econtrado");
        }
    }catch(ProductNotFoundExeception e){
        System.out.println(e.getMessage());
        System.out.println("-----------------------------------");
    }  
    }  

    private static void eliminarProducto() {
        try{
            System.out.println("-----------------------------------");
            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();
            producto productoEncontrado = null;
            for (producto producto: productos) {
                if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                    productoEncontrado = producto;
                    break;
                }
            }
            if (productoEncontrado != null) {
                productos.remove(productoEncontrado);
                System.out.println("producto eliminado correctamente.");
                System.out.println("-----------------------------------");
            }else {
                throw new ProductNotFoundExeception("producto no encontrado.");           
            }
        }catch(ProductNotFoundExeception e){
        System.out.println(e.getMessage());
        System.out.println("-----------------------------------");
    }

    
    }        
}   

