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
S c S     S G S
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

Layer 0:      Layer 1:
S S d S S     s s s s s
S S S S S     s s s s s
D S S S D     s s s s s
S S S S S     s s s s s
S S c S S     s s s s s
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

Layer 0:          Layer 1:          Layer 2:
S S S d S S S     S S S S S S S     S S S S S S S
D S S S S S D     S D w w w D S     S S S S S S S
S S S c S S S     S S g g g S S     S S S S S S S
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

Layer 0:  Layer 1:  Layer 2:
S d S     S S S     S S S
D S D     S w S     S S S
S c S     S g S     S S S
```

