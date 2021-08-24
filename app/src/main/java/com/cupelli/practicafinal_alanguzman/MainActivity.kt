package com.cupelli.practicafinal_alanguzman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.IllegalArgumentException
import java.lang.reflect.Array
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petNumber = Random.nextInt(0,8)
        checkPet(petNumber)

    }

    var check: Boolean = true
    //var first: Boolean = true
    fun makeSound(view: View) {
        if(check == true) {
            centinelArrays = centinelArrays-1
            check = false
        }
        Toast.makeText(this,arregloSonido[centinelArrays], Toast.LENGTH_SHORT).show()

    }
    fun goPlay(view: View) {
        if(check == true) {
            centinelArrays = centinelArrays-1
            check = false
        }
        Toast.makeText(this,arregloJuego[centinelArrays], Toast.LENGTH_SHORT).show()
    }
    fun goEat(view: View) {
        if(check == true) {
            centinelArrays = centinelArrays-1
            check = false
        }
        Toast.makeText(this,arregloComida[centinelArrays], Toast.LENGTH_SHORT).show()
    }
    fun getPreviousPet(view: View) {

        if(centinelArrays > 0)
        {
            /*if(first == true) {
                centinelArrays -= 1
                first = false
            }*/
            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = arregloDeMascota[--centinelArrays]
            if(check == false)
            {
                check=true
                centinelArrays += 1
            }
        }
        else
        {
            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = "Ops! Llegaste al límite de los previos. Mejor busca hacia adelante"
            ++centinelArrays
        }
    }
    fun createNewPet(view: View) {
        val petNumber = Random.nextInt(0,8)
        checkPet(petNumber)
    }
    fun getNextPet(view: View) {
        if(centinelArrays < 5)
        {
            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = arregloDeMascota[++centinelArrays]
            if(check == false)
            {
                check=true
                centinelArrays += 1
            }
        }
        else
        {
            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = "Ops! Llegaste al límite de los posteriores. Mejor busca hacia atrás"
            --centinelArrays
        }
    }

    /*Área de VARIABLES */

    var arregloDeMascota = arrayOf<String>("Amaretto","Capuccino","Oggy","Kiky","Niño","Peluso")
    var centinelArrays = 0
    var dogCentinel = 0
    var catCentinel = 0

    var arregloSonido = arrayOf<String>("A","B","C","D","E","F")
    var arregloJuego = arrayOf<String>("Z","X","V","W","U","Y")
    var arregloComida = arrayOf<String>("C","O","M","I","D","A")


    //Arreglos perrunas
    val firstDog = arrayOf<String>("Amaretto", "Pastor Belga", "5", "Juguetón","Amaretto juega con su hueso","Guau guau !",
    "Amaretto está comiendo caldo de pollo")
    val secondDog = arrayOf<String>("Capuccino", "Nova Scotia", "4", "Calmado","Capuccino es serio, no quiere jugar",
        "Woof !","Capuccino está devorando sus galletitas")
    val thirdDog = arrayOf<String>("Oggy", "French Puddle", "6", "Miedoso","Oggy mueve su colita para jugar","Wau wuau",
    "Oggy come salchicha y croquetas")

    //Arreglos gatunos
    val firstCat = arrayOf<String>("Kiky", "Gato Persa", "1", "Violento","Kiky juega con su bola de estambre","Miau miau",
    "Kiky come su Whiskas")
    val secondCat = arrayOf<String>("Niño", "Maine Coon", "4", "Sigiloso","Niño está jugando al espía","Miau",
    "Niño está tan concentrado que no quiere comer")
    val thirdCat = arrayOf<String>("Peluso", "Ragdoll", "2", "Sensual","Peluso no juega, baila","Miauuuu",
    "Peluso come Whiskas mientras baila")

    /*Área de FUNCIONES */

    fun checkPet(petNumber: Int)
    {
        if(petNumber % 2 == 0)
        {
            var printedDog = when{
                dogCentinel == 0 -> "Nombre de mascota: ${firstDog[0]}\nRaza: ${firstDog[1]}" +
                        "\nEdad: ${firstDog[2]}\nPersonalidad: ${firstDog[3]}"
                dogCentinel == 1 -> "Nombre de mascota: ${secondDog[0]}\nRaza: ${secondDog[1]}" +
                        "\nEdad: ${secondDog[2]}\nPersonalidad: ${secondDog[3]}"
                dogCentinel == 2 -> "Nombre de mascota: ${thirdDog[0]}\nRaza: ${thirdDog[1]}" +
                        "\nEdad: ${thirdDog[2]}\nPersonalidad: ${thirdDog[3]}"
                else -> "Ops, algo salió mal o has alcanzado el límite de perros :("
            }

            if(dogCentinel == 0)
            {
                arregloJuego[centinelArrays] = firstDog[4].toString()
                arregloSonido[centinelArrays] = firstDog[5].toString()
                arregloComida[centinelArrays] = firstDog[6].toString()
            }
            if(dogCentinel == 1)
            {
                arregloJuego[centinelArrays] = secondDog[4].toString()
                arregloSonido[centinelArrays] = secondDog[5].toString()
                arregloComida[centinelArrays] = secondDog[6].toString()
            }
            if(dogCentinel == 3)
            {
                arregloJuego[centinelArrays] = thirdDog[4].toString()
                arregloSonido[centinelArrays] = thirdDog[5].toString()
                arregloComida[centinelArrays] = thirdDog[6].toString()
            }

            if(dogCentinel <= 2)
            {
                dogCentinel++
                arregloDeMascota.set(centinelArrays, printedDog)
                centinelArrays++
            }

            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = printedDog
        }
        else
        {
            var printedCat = when{
                catCentinel == 0 -> "Nombre de mascota: ${firstCat[0]}\nRaza: ${firstCat[1]}" +
                        "\nEdad: ${firstCat[2]}\nPersonalidad: ${firstCat[3]}"
                catCentinel == 1 -> "Nombre de mascota: ${secondCat[0]}\nRaza: ${secondCat[1]}" +
                        "\nEdad: ${secondCat[2]}\nPersonalidad: ${secondCat[3]}"
                catCentinel == 2 -> "Nombre de mascota: ${thirdCat[0]}\nRaza: ${thirdCat[1]}" +
                        "\nEdad: ${thirdCat[2]}\nPersonalidad: ${thirdCat[3]}"
                else -> "Ops, algo salió mal o has alcanzado el límite de gatos :("
            }

            if(catCentinel == 0)
            {
                arregloJuego[centinelArrays] = firstCat[4].toString()
                arregloSonido[centinelArrays] = firstCat[5].toString()
                arregloComida[centinelArrays] = firstCat[6].toString()
            }
            if(catCentinel == 1)
            {
                arregloJuego[centinelArrays] = secondCat[4].toString()
                arregloSonido[centinelArrays] = secondCat[5].toString()
                arregloComida[centinelArrays] = secondCat[6].toString()
            }
            if(catCentinel == 3)
            {
                arregloJuego[centinelArrays] = thirdCat[4].toString()
                arregloSonido[centinelArrays] = thirdCat[5].toString()
                arregloComida[centinelArrays] = thirdCat[6].toString()
            }

            if(catCentinel <= 2)
            {
                catCentinel++;
                arregloDeMascota.set(centinelArrays, printedCat)
                centinelArrays++
            }

            lateinit var textVariable: TextView
            textVariable = findViewById(R.id.txvInfo)
            textVariable.text = printedCat
        }
    }


}