package paquete;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private String nombre;
    private List<Producto> productos;
    private List<Empleado> empleados;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<Producto>();
        this.empleados = new ArrayList<Empleado>();
    }
    public List<Producto> getProductos() {
		return productos;
	}
    
	public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String n) {
    	this.nombre = n;
    }
    
    public List<Empleado> getEmpleado() {
		return empleados;
	}

    public boolean agregarProducto(Producto producto) {
        return productos.add(producto);
    }

    public boolean eliminarProducto(Producto producto) {
       //return productos.removeIf(producto -> producto.getNombre().equals(nombreProducto));
    	
    	return productos.remove(producto);
    }

    public boolean tieneProducto(String nombreProducto) {
    	boolean existe=false;
    	int i=0;
    	while(i<productos.size() && existe==false) {
    		if(productos.get(i).getNombre().equals(nombreProducto)) {
    			existe=true;
    		}
    		i++;
    	}
        //return productos.stream().anyMatch(producto -> producto.getNombre().equals(nombreProducto));
    	return existe;
    }
    
    /*public boolean tieneProducto(Producto producto) {
    	boolean existe=false;
    	int i=0;
    	while(i<productos.size() && existe==false) {
    		if(productos.get(i).getNombre().equals(producto.getNombre())) {
    			existe=true;
    		}
    		i++;
    	}
        //return productos.stream().anyMatch(producto -> producto.getNombre().equals(nombreProducto));
    	return existe;
    }*/

    public int CantidadTotalProductos() {
        return productos.size();
    }

    public double obtenerPrecio(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto.getPrecio();
            }
        }
        
        return 0; 
    }

   /* public double obtenerPrecio(Producto p) {
    	for(Producto producto : productos) {
        	if(producto.getNombre().equals(p.getNombre())) {
        		return producto.getPrecio();
        	}
        }
        
        return 0; 
    }*/
    
    public void mostrarProductos() {
        System.out.println("Productos en la tienda " + nombre + ":");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + ": " + producto.getPrecio() + " euros.");
        }
    }

    public boolean agregarEmpleado(Empleado empleado){
		/*int id=1;
		if(traerUsuario(nombreUsuario)!=null){
			throw new Exception("Usuario ya existente");
		}
		if(lstUsuarios.size()>0) {
			int tam=lstUsuarios.size();
			id=lstUsuarios.get(tam-1).getIdUsuario()+1;
		}*/
		
		return empleados.add(empleado);
	}
    
    public int EmpleadosPorSector(String sector) {
    	int total=0;
    	for(int i=0;i<empleados.size();i++) {
    		if(empleados.get(i).getSectorDeTrabajo().equals(sector)) {
    			total++;
    		}
    		
    	}
    	return total;
    }
    
    public Producto traerProducto(String nombre) {
    	Producto p= null;
    	int i=0;
    	while(i<productos.size() && p==null) {
    		if(productos.get(i).getNombre().equals(nombre)) {
    			p=productos.get(i);
    		}
    		i++;
    	}
    	return p;
    }

}
