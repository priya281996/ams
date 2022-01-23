
import React, { Component } from 'react'
import {getDeliveryEntityById} from './Service/api'

class ViewDelivery extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            deliveryEntity: {}
        }
    }

    componentDidMount(){
        getDeliveryEntityById(this.state.id).then( res => {
            this.setState({deliveryEntity: res.data});
           
        })
        
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Delivery Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Delivery Owner Name: </label>
                            <div> {this.state.deliveryEntity.ownerName}</div>
                        </div>
                        <div className = "row">
                            <label> Delivery Time: </label>
                            <div> {this.state.deliveryEntity.time}</div>
                        </div>

                        <div className = "row">
                            <label> Delivery Date: </label>
                            <div> {this.state.deliveryEntity.date}</div>
                        </div>

                        <div className = "row">
                            <label> Delivery Status: </label>
                            <div> {this.state.deliveryEntity.status}</div>
                        </div>
                        
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDelivery