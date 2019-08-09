import React from 'react';
import { Table } from 'reactstrap';
import { PokeRow } from './pokeRow.js';

export function PokeList(props) {
    return (
        <div>
            <Table>
                <thead>
                    <tr>
                        <th>first name</th>
                        <th>last name</th>
                        <th>acc No.</th>
                        <th>Prize</th>
                    </tr>
                </thead>
                <PokeRow data={props.data}/>
            </Table>
        </div>
        )
 }