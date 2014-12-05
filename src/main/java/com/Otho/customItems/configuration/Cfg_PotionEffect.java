package com.Otho.customItems.configuration;

public class Cfg_PotionEffect {	
		public String effect = "moveSpeed";
		public int potionDuration = 30;
		public int potionAmplifier = 0;
		public float potionEffectProbability = 1;		
		
		public static int potionEffectId (String effect)
		{
			if(effect.equals("moveSpeed"))
			{
				return 1;
			}
			else if(effect.equals("moveSlowdown"))
			{
				return 2;
			}
			else if(effect.equals("digSpeed"))
			{
				return 3;
			}
			else if(effect.equals("digSlowdown"))
			{
				return 4;
			}
			else if(effect.equals("damageBoost"))
			{
				return 5;
			}
			else if(effect.equals("heal"))
			{
				return 6;
			}
			else if(effect.equals("harm"))
			{
				return 7;
			}
			else if(effect.equals("jump"))
			{
				return 8;
			}
			else if(effect.equals("confusion"))
			{
				return 9;
			}
			else if(effect.equals("regeneration"))
			{
				return 10;
			}
			else if(effect.equals("resistance"))
			{
				return 11;
			}
			else if(effect.equals("fireResistance"))
			{
				return 12;
			}
			else if(effect.equals("waterBreathing"))
			{
				return 13;
			}
			else if(effect.equals("invisibility"))
			{
				return 14;
			}
			else if(effect.equals("blindness"))
			{
				return 15;
			}
			else if(effect .equals("nightVision"))
			{
				return 16;
			}
			else if(effect.equals("hunger"))
			{
				return 17;
			}
			else if(effect.equals("weakness"))
			{
				return 18;
			}
			else if(effect.equals("poison"))
			{
				return 19;
			}
			else if(effect.equals("wither"))
			{
				return 20;
			}
			else if(effect.equals("healthBoost"))
			{
			    return 21;
			}
			else if(effect.equals("healthBoost"))
			{
			    return 22;
			}
			else if(effect.equals("healthBoost"))
			{
			    return 23;
			}
			else
			{
				return 6;
			}		
		}
}
