# industrial-crafting
multiblock machines for minecraft

## Machines  
This document lists all machines, how they work and how they are built.  
All machines must be constructed using their base materials, and then be activated using the blueprint.  
To do so the bottom right block on the front must be right clicked.  

The instructions for construction are done using this layout:
```
Materials:  
S : smooth stone  
C : chest  
D : dropper  
d : dispenser  
G : glass

Layer 0:  Layer 1:
S D S     S S S
d S d     S   S
S C S     S G S
```

<br>

## Centrifuge  
This machine is used to separate dust into smaller components.  
The result is usually heavily contaminated.  

```
Materials:
S : smooth stone
s : smooth stone slab
D : dropper
d : dispenser
C : chest

Layer 0:      Layer 1:
S S d S S     s s s s s
S S S S S     s s s s s
D S S S D     s s s s s
S S S S S     s s s s s
S S C S S     s s s s s
```

## Chemical Refinery  
This machine is used to convert normal minecraft items like water buckets to usable chemicals.  
This machine has no assignable recipes, it just do its job.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : tinted glass
w : water
C : chest

Layer 0:          Layer 1:          Layer 2:
S S S d S S S     S S S S S S S     S S S S S S S
D S S S S S D     S D w w w D S     S S S S S S S
S S S C S S S     S S g g g S S     S S S S S S S
```

## Condenser  
This machine is both used as a condenser and as a distillation apparatus.  
It can be used to dry salt, but also to separate the different components of alcohol.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : glass
w : water
C : chest

Layer 0:  Layer 1:  Layer 2:
S d S     S S S     S S S
D S D     S w S     S S S
S C S     S g S     S S S
```

## Electrolyzer  
This machine will split molecules like H2O into their atoms, if this is possible.  
The substance needs to be conductive, and as Water is not conductive, an acid is required as a catalyst and will therefore not be consumed.    
A cheap alternative would be adding salt, which will be decomposed and release chlorine gas.  
The construction is the same as the condenser.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : glass
w : water
C : chest

Layer 0:  Layer 1:  Layer 2:
S d S     S S S     S S S
D S D     S w S     S S S
S C S     S g S     S S S
```

## Furnace  
A furnace is used to burn compounds or to react chemicals under high pressure and temperature.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : tinted glass
b : blast furnace
C : chest

Layer 0:  Layer 1:  Layer 2:  Layer 3:
S d S     S S S     S S S     S S S
D S D     S b S     S   S     S   S
S C S     S g S     S S S     S S S
```

## Macerator  
A macerator is used to crush solid blocks into powder, so they can either be separated or directly used.  

```
Materials:
S : smooth stone
s : smooth stone slab 
D : dropper
d : dispenser
C : chest

Layer 0:  Layer 1:
D d D     s s s
S C S     s s s
```

## Reactor  
The reactor is used to react chemicals.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : glass
c : cauldron
l : lightning rod
C : chest

Layer 0:  Layer 1:  Layer 2:
S d S     S S S     S S S
D c D     S l S     S S S
S C S     S g S     S S S
```

## Recrystallizer  
Some contaminated chemicals can be purified through recrystallisation. This is only possible for crystalline chemicals, like NaCl.  
The result will be of industrial grade purity, but take a lot of time.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : tinted glass
w : water
C : chest

Layer 0:  Layer 1:  Layer 2:  Layer 3:  Layer 4:
S d S     S S S     S S S     S S S     S S S
D S D     S w S     S w S     S w S     S S S
S C S     S g S     S g S     S g S     S S S
```

## Solar Electrolyzer  
This device will generate it's energy using "solar cells" (daylight sensors) and use that to drive electrolysis.  
Note that it will work best in warm biomes like deserts and not at all in cold biomes.  
Speaking in numbers, it will not be generating anything below a temperature of 0.5, above it will generate 0.5 power units per second.  
Above 1.0, it will be 1.5 power units per second and at 2.0 it will be 2.0 power units per second.  
Note that access to daylight is required, and that the cells cannot be obscured.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : glass
w : water
x : daylight sensor
C : chest

Layer 0:  Layer 1:  Layer 2:  Layer 3:
S d S     S S S     S S S     x x x
D S D     S w S     S S S     x x x
S C S     S g S     S S S     x x x
```

## Weapon Assembly  
This machine will craft weapons.  
Power and time demands are very high, yet dependant on the recipe, of course.  
It is also used to craft ammunition and to do so the weapon recipe must be shift-right-clicked on the machine when applying.  
Note that a hopper is required. It has to face towards the output slot on the right, as indicated by the arrow in the instructions.  

```
Materials:
S : smooth stone
D : dropper
d : dispenser
g : tinted glass
> : hopper
b : blast furnace
C : chest

Layer 0:      Layer 1:      Layer 2:      Layer 3:
S S d S S     S S S S S     S S S S S     S S S S S
D S S > D     S S S   S     S S S   S     S S S S S
S S C S S     S b S g S     S b S g S     S S S S S
```
