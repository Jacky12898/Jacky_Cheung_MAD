//
//  ViewController.swift
//  Project 1
//
//  Created by Jacky Cheung on 9/30/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var sliderState = false
    var buttonState = false
    var win = false
    var x = CGFloat(0)
    var y = CGFloat(0)

    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var slider: UISlider!
    
    @IBAction func sliderAction(_ sender: Any) {
        if(sliderState){
            label.transform = CGAffineTransform(translationX: x, y: CGFloat(slider.value * 100) + 60)
            
            y = CGFloat(slider.value * 100) + 60
        }
        
        else{
            label.transform = CGAffineTransform(translationX: CGFloat(slider.value * 100), y: y)
            
            x = CGFloat(slider.value * 100)
        }
        
        if(slider.value == 1){
            buttonState = true
        }
        
        if(slider.value == -1){
            rotateButton.isHidden = false
        }
        
        if(buttonState){
            hiddenButton.isEnabled = true;
        }
    }
    
    @IBOutlet weak var button: UISwitch!
    
    @IBAction func hideButton(_ sender: Any) {
        if(button.isOn){
            hiddenButton.isHidden = false
        }
    }
    
    @IBOutlet weak var hiddenButton: UISwitch!
    
    @IBAction func changeSliderFunction(_ sender: Any) {
        if(hiddenButton.isOn){
            sliderState = true
        }
        
        else{
            sliderState = false
        }
    }
    
    @IBOutlet weak var Box:UIImageView!
    
    @IBAction func Reset(_ sender: UIButton){
        if sender.tag == 1{
            label.transform = CGAffineTransform(translationX: 0, y: 0)
            
            hiddenButton.isOn = false
            hiddenButton.isEnabled = false
            hiddenButton.isHidden = true
            
            slider.value = 0
            
            rotateButton.isHidden = true
            
            button.isOn = false
            button.isHidden = false
            
            slider.isHidden = false
            
            sliderState = false
            buttonState = false
            win = false
            x = CGFloat(0)
            y = CGFloat(0)
        }
    }
    
    @IBOutlet weak var rotateButton:UIButton!
    
    @IBAction func Rotate(_ sender: UIButton){
        if sender.tag == 2{
            var t = CGAffineTransform.identity
            t = t.translatedBy(x: x, y: y)
            t = t.rotated(by: CGFloat.pi/2)
            
            label.transform = t
        }
        
        checkWin()
        if(win){
            slider.isHidden = true
            hiddenButton.isHidden = true
            button.isHidden = true
            rotateButton.isHidden = true
            
            let alert = UIAlertController(title: "You Win!", message: "Congrats on figuring out the UI puzzle", preferredStyle: UIAlertController.Style.alert)
            let ok = UIAlertAction(title: "Cool", style: UIAlertAction.Style.default, handler: nil)
            alert.addAction(ok)
            
            self.present(alert, animated: true)
        }
    }
    
    func checkWin(){
        if(((label.frame.origin.x <= Box.frame.origin.x + 12) && (label.frame.origin.x >= Box.frame.origin.x - 12)) && ((label.frame.origin.y <= Box.frame.origin.y + 8) && (label.frame.origin.y >= Box.frame.origin.y - 8))){
            win = true
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
