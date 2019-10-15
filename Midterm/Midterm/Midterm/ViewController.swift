//
//  ViewController.swift
//  Midterm
//
//  Created by Jacky Cheung on 10/15/19.
//  Copyright © 2019 Jacky Cheung. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var roundTrip: UITextField!
    
    @IBOutlet weak var gasTankLabel: UILabel!
    @IBOutlet weak var gasTankValue: UISlider!
    @IBAction func gasTank(_ sender: UISlider) {
        gasTankLabel.text = "Gas in tank: " + String(format: "%.0f", gasTankValue.value) + " gallons"
    }
    
    @IBOutlet weak var transportationMethod: UISegmentedControl!
    
    @IBOutlet weak var totalCommuteTime: UILabel!
    @IBOutlet weak var gasToPurchase: UILabel!
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var monthly: UISwitch!
    
    func calculate(){
        var mph:Float
        var wait:Float
        var hours:Float
        var gas:Float
        var gasNeeded = false
        
        if (transportationMethod.selectedSegmentIndex == 0){
            mph = 20.0
            wait = 0.0
            gasNeeded = true
            image.image = UIImage(named: "car_icon")
        }
        
        else if(transportationMethod.selectedSegmentIndex == 1){
            mph = 12.0
            wait = 1/6
            gasNeeded = false
            image.image = UIImage(named: "bus_icon")
        }
        
        else {
            mph = 10.0
            wait = 0.0
            gasNeeded = false
            image.image = UIImage(named: "bike_icon")
        }
        
        hours = Float(roundTrip.text!)! / mph + wait
        
        gas = Float(roundTrip.text!)! / 24.0
        
        if(monthly.isOn){
            hours = hours * 20
            gas = gas * 20
        }
        
        totalCommuteTime.text = String(format: "%.2f", hours) + " hours"
        
        if(gasNeeded){
            gasToPurchase.text = String(format: "%.2f", gas) + " gallons"
        }
        
        else{
            gasToPurchase.text = "0.0 gallons"
        }
    }
    
    @IBAction func commuteButton(_ sender: UIButton) {
        calculate()
        if(transportationMethod.selectedSegmentIndex == 0){
            let alert = UIAlertController(title: "Suggestion", message: "Try carpooling!", preferredStyle: UIAlertController.Style.alert)
            
            let ok = UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: nil)
            
            alert.addAction(ok)
            
            present(alert, animated: true, completion: nil)
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        roundTrip.delegate = self
        super.viewDidLoad()
    }
}

