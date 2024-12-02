package com.example.proyecto;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyecto.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Declaración de NavControllers para gestionar diferentes gráficos de navegación
    private NavController navControllerBottom, navControllerOptions, navControllerDrawer;

    // Configuración del AppBar y el DrawerLayout
    private AppBarConfiguration appBarConfiguration;
    private DrawerLayout drawerLayout;

    // Binding para acceder a los elementos de la vista
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuración del layout con View Binding
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        // Configurar la Toolbar como barra de acción
        setSupportActionBar(binding.toolbar);

        // Establecer manualmente el título de la aplicación en la Toolbar
        setTitle(getString(R.string.app_name));

        // Asignar el DrawerLayout desde el binding
        drawerLayout = binding.drawerLayout;

        // Configurar los NavControllers para cada gráfico de navegación
        navControllerBottom = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController(); // Controla el BottomNavigationView
        navControllerOptions = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment2)).getNavController(); // Controla el menú de opciones
        navControllerDrawer = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment3)).getNavController(); // Controla el Drawer

        // Configurar AppBarConfiguration para gestionar la navegación con el Drawer
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.drawer1Fragment, R.id.drawer2Fragment, R.id.drawer3Fragment // Destinos principales del Drawer
        ).setOpenableLayout(drawerLayout).build();

        // Configurar el DrawerLayout con un ActionBarDrawerToggle (botón hamburguesa)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle); // Agregar el listener para sincronizar el estado
        toggle.syncState(); // Sincronizar el estado inicial del botón hamburguesa

        // Configurar el NavigationView con el NavController del Drawer
        NavigationUI.setupWithNavController(binding.navView, navControllerDrawer);

        // Configurar el BottomNavigationView para interactuar con el NavController correspondiente
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            // Mostrar el NavHostFragment del BottomNavigationView y ocultar los demás
            findViewById(R.id.nav_host_fragment).setVisibility(View.VISIBLE);
            findViewById(R.id.nav_host_fragment2).setVisibility(View.GONE);
            findViewById(R.id.nav_host_fragment3).setVisibility(View.GONE);

            // Navegar al destino seleccionado
            return NavigationUI.onNavDestinationSelected(item, navControllerBottom);
        });

        // Configurar el NavigationView para interactuar con el NavController del Drawer
        binding.navView.setNavigationItemSelectedListener(item -> {
            // Mostrar el NavHostFragment del Drawer y ocultar los demás
            findViewById(R.id.nav_host_fragment).setVisibility(View.GONE);
            findViewById(R.id.nav_host_fragment2).setVisibility(View.GONE);
            findViewById(R.id.nav_host_fragment3).setVisibility(View.VISIBLE);

            // Navegar al destino seleccionado en el Drawer
            boolean handled = NavigationUI.onNavDestinationSelected(item, navControllerDrawer);
            drawerLayout.closeDrawer(GravityCompat.START); // Cerrar el Drawer después de seleccionar una opción
            return handled;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú de opciones en la Toolbar
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Mostrar el NavHostFragment de opciones y ocultar los demás
        findViewById(R.id.nav_host_fragment).setVisibility(View.GONE);
        findViewById(R.id.nav_host_fragment2).setVisibility(View.VISIBLE);
        findViewById(R.id.nav_host_fragment3).setVisibility(View.GONE);

        // Navegar al destino seleccionado en el menú de opciones
        return NavigationUI.onNavDestinationSelected(item, navControllerOptions)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Si el Drawer está abierto, ciérralo en lugar de salir
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // Comportamiento predeterminado del botón "Atrás"
            super.onBackPressed();
        }
    }
}
