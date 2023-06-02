# industrial-crafting
multiblock machines for minecraft

## About  
This is a minecraft plugin that adds multiblock machines and recipes to produce various chemicals and weapons for a certain datapack.  
The weapons themselves are from this amazing datapack: https://www.youtube.com/watch?v=Ia5Mlkn6ipM  

<br>

## Disclaimer  
The synthesis-machanisms for some chemicals have been slightly simplified or modified for two reasons:  
- some recipes would be extremely complicated  
- some chemicals are controlled and restricted for obvious reasons and I legaly cannot provide detailed instructions on their manufacture  

The synthesis mechanisms have been derived from public information. I do not provide any information that would not be available otherwise!  
Do not attempt to reproduce any of the chemical recipes at home!  
Not only are they extremely dangerous, but also restrited by the government!  

<br>

## Index  
Index for this document:  
- [Usage](#usage)  
- [About machines](#about-machines)  
- [Added machines](#added-machines)  
- [About weapons](#about-weapons)  
- [About chemicals](#about-chemicals)  
- [Added chemicals](#added-chemicals)  


Refer to these documents for detailed information:  
- [Machines](MACHINES.md)  
- [Chemical crafting](CHEMICALS.md)
- [Weapon crafting](WEAPONS.md)  

<br>

## Usage  
All recipes and machines are obtained by first crafting a "blueprint" using one paper and one blue dye.  
The blueprint can be written using:  
`/setrecipe` : choose from a list of all available recipes  
`/setmachine`: choose from a list of all available machines  
`/setweapon`: choose from a list of all available weapons  
Note that shift-right clicken the weapon assembly with a weapon blueprint will cause it to craft ammo.  

<br>

## About machines  
To build a machine, one must first lay out their structure using their base materials: smooth stone, chests, dispensers...  
More on that in the section "added machines".  
After building the structure, the bottom right block of the structure must be clicked with the blueprint for this machine.  
If all blocks match the requirements, the machine will be constructed and is now ready to use.  

Most machines have the following interfaces with each a different purpose:  
| Interface name | description |  
| --- | --- |  
| Generator | Some recipes require different amounts of energy. Fuel must be placed in here. |  
| Input | The input hatch is used to supply the machine with materials. |  
| Output | All crafted items, as well as chemical waste appear here. |  
| Interface | This is used to get an overview of the current job, the power level and is used to power on the machine. |  

Fuel options:  
Machines can be powered using normal minecraft fuel: lava bucket, coal block, coal, charcoal, dried kelp and blaze rods or chemicals: Hydrogen, Methanol, Ethanol or Acetone.  

Before a machine can be used to manufacture anything, a recipe must be set.  
To do so, the bottom right block of the machine must be clicked with a blueprint containing the recipe.  
Note, that not all recipes work on all machines!  

<br>

## Added machines  
The following machines have been added.  
Click on any of them to get detailed instructions.  
| Machine | description |  
| --- | --- |  
| Chemical refinery | Used to convert normal minecraft items to usable chemicals. |
| Recrystallizer | Used to purify some cristalline chemicals like sulfur. |
| Macerator | Crush blocks to powder. |
| Condenser | Separate solids from fluids and distill fluid mixtures. |
| Macerator | Crush blocks into powder. |
| Centrifuge | Separate powders. |
| Electrolyser | Separate molecules through electrolysis. |
| Solar Electrolyser | The same as the normal electrolyser, but powered by the sun. |
| Weapon assembly | Craft weapons |
| Furnace | Burn materials. |

<br>

## About weapons  
All weapons and magazines can only be crafted using machines.  
The blueprint needs to be written and supplied to a weapon assembly machine.  

<br>

## About chemicals  
This plugin adds many new chemicals, some with certain abilities.  
Every chemical has a certain purity assigned.  

Some chemicals that are either extremely flammable or explosive will create an explosion when dropped into fire.  

Unpure chemicals have the following undesirable side effects:  
- the crafted material will (usually) also be contaminated  
- in a final crafting stage, the recipe has an increased chance of producing junk  
- if throwable explosives like TATP are contaminated, there is an increasing chance of spontaneous decomposition upon throwing  

These are the purity rates, ranked from worst to best:  
- Heavy contaminations  
- Contaminated  
- Low contaminations  
- Considered clean  
- Commercial grade purity  
- Industrial grade purity  

Important Note: all normal minecraft items (list below) need to be refined with the chemical refinary. This sucks, and the only reason is the way I implemented the crafting.  

<br>

## Added chemicals  
The following materials/chemicals were added.  
Click on any of them to get detailed information on their usage and synthesis.  
| Raw | Special | Material |
| --- | --- | --- |
| :x: | - | Acetic acid |
| :x: | - | Acetone |
| :x: | explosive | Acetone peroxide |
| :white_check_mark: | - | Apple |
| :white_check_mark: | - | Calcite |
| :x: | - | Calcium carbonate |
| :x: | - | Carbon |
| :x: | - | Carbon dioxide |
| :x: | - | Carbon monoxide |
| :x: | - | Chlorinated hydrocarbons |
| :x: | - | Chlorine |
| :x: | tear gas | Chloroacetone |
| :x: | tear gas | Chloroform |
| :white_check_mark: | - | Coal |
| :white_check_mark: | - | Cobble stone |
| :x: | - | Crushed netherrack |
| :x: | - | Distilled water |
| :white_check_mark: | - | Empty bucket |
| :x: | - | Ethanol |
| :x: | required for ammunnition | Gun powder |
| :x: | - | Hydrogen |
| :x: | - | Hydrogen peroxide |
| :white_check_mark: | - | Iron |
| :x: | - | Liquor |
| :x: | - | Metal dust |
| :x: | - | Methane |
| :x: | - | Methanol |
| :white_check_mark: | - | Netherrack |
| :white_check_mark: | - | Organic waste (rotten flesh)|
| :x: | - | Oxygen |
| :x: | - | Phosphorous |
| :x: | - | Potassium chlorate |
| :x: | - | Potassium chloride |
| :x: | - | Potassium hydroxide |
| :x: | - | Potassium hydroxide (solution) |
| :x: | - | Potassium nitrate |
| :x: | required for ammunition | Primer powder |
| :x: | - | Sodium acetate |
| :x: | - | Sodium carbonate |
| :x: | - | Sodium chloride |
| :x: | - | Sodium hydroxide |
| :x: | - | Sodium hydroxide (solution) |
| :white_check_mark: | - | Soil |
| :x: | - | Stone dust |
| :white_check_mark: | - | Sugar cane |
| :x: | - | Sulfur |
| :x: | - | Sulfur dioxide |
| :x: | - | Sulfuric acid |
| :x: | - | Sulfur trioxide |
| :white_check_mark: | - | Water |
| :x: | - | Waste |
